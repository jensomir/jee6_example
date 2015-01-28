package net.jenshemme;

import net.jenshemme.domain.Address;
import net.jenshemme.domain.House;
import net.jenshemme.domain.Project;
import net.jenshemme.instrumentation.ProjectManipulatorDecorator;
import net.jenshemme.service.HousePlanner;
import net.jenshemme.service.ProjectManipulator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.naming.NamingException;
import java.util.Date;
import java.util.Properties;

import static org.junit.Assert.*;

public class HousePlannerTest {

    private static EJBContainer container;
    private static long startPoint;

    private static final Address myAddress = new Address("Drosselgasse 23", "Heidelberg", "87653");

    @Before
    public void start() throws NamingException {
        startPoint = new Date().getTime();

        Properties p = new Properties();
        p.put("plouseds", "new://Resource?type=DataSource");
        p.put("plouseds.JdbcDriver", "org.postgresql.Driver");
        p.put("plouseds.JdbcUrl", "jdbc:postgresql://localhost:5432/plouse");
        p.put("plouseds.UserName", "plouse");
        p.put("plouseds.Password", "plouse");

        container = EJBContainer.createEJBContainer(p);
        container.getContext().bind("inject", this);

    }

    @After
    public void stop() {
        container.close();
        long endPoint = new Date().getTime();
        double testDuration = endPoint - startPoint;
        System.out.println("test took about: " + testDuration / 1000 + "s");
    }

    @EJB
    HousePlanner testSubject;

    @Inject
    ProjectManipulator projectManipulator;

    @Test
    public void testCreateEmptyProject() throws Exception {
        assertNotNull(testSubject);
        Project emptyProject = testSubject.createProject(null, null);
        System.out.println(emptyProject);
        assertNotNull(emptyProject);
        assertNull(emptyProject.getProjectManager());
    }

    @Test
    public void testDecorator() throws Exception {
        assertNotNull(testSubject);
        Project project = testSubject.createProject(null, null);
        assertNull(project.getProjectManager());
        projectManipulator.setRandomProjectManager();
        assertNotNull(projectManipulator.getProjectManager());
        assertEquals(ProjectManipulatorDecorator.cleverGuy.getName(), projectManipulator.getProjectManager().getName());
    }

    @Test
    public void testInterceptors() throws Exception {
        assertNotNull(testSubject);
        Project project = testSubject.createProject(null, null);
        assertNotNull(project.getHouses());
        project.addHouse(new House(null, myAddress));
        try {
            testSubject.updateProjectWithoutLogin(project);
            fail("SecurityException was not thrown - Interceptor does not work properly!");
        } catch (Exception ex) {
            // do nothing, Exception is expected
        }
        testSubject.updateProject(project); // does not throw Exception
    }
}