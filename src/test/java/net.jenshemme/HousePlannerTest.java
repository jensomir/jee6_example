package net.jenshemme;

import net.jenshemme.domain.Address;
import net.jenshemme.domain.House;
import net.jenshemme.domain.Project;
import net.jenshemme.instrumentation.ProjectDecorator;
import net.jenshemme.service.HousePlanner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import java.util.Date;

import static org.junit.Assert.*;

public class HousePlannerTest {

    private static EJBContainer container;
    private static long startPoint;

    private static final Address myAddress = new Address("Drosselgasse 23", "Heidelberg", "87653");

    @Before
    public void start() throws NamingException {
        startPoint = new Date().getTime();
        container = EJBContainer.createEJBContainer();
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
    private HousePlanner testSubject;


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
        project.setRandomProjectManager();
        assertNotNull(project.getProjectManager());
        assertEquals(ProjectDecorator.cleverGuy.getName(), project.getProjectManager().getName());
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