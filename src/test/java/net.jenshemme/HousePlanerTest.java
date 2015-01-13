package net.jenshemme;

import net.jenshemme.domain.Project;
import net.jenshemme.service.HousePlaner;
import org.junit.*;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import java.util.Date;
import java.util.Properties;

import static org.junit.Assert.assertNotNull;

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
        System.out.println("test took " + (endPoint - startPoint)/1000 + "s");
    }

    @EJB
    private HousePlaner testSubject;

    @Test
    public void testCreateEmptyProject() throws Exception {
        assertNotNull(testSubject);
        Project emptyProject = testSubject.createProject(null, null);
        System.out.println(emptyProject);
        assertNotNull(emptyProject);
    }
}