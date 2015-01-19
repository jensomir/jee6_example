package net.jenshemme;

import net.jenshemme.domain.Project;
import net.jenshemme.instrumentation.ProjectDecorator;
import net.jenshemme.service.HousePlaner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import java.util.Date;

import static org.junit.Assert.*;

public class HousePlanerTest {

    private static EJBContainer container;
    private static long startPoint;

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
    private HousePlaner testSubject;

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
}