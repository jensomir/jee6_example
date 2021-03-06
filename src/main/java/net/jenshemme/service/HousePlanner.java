package net.jenshemme.service;

import net.jenshemme.context.ContextRegistry;
import net.jenshemme.domain.House;
import net.jenshemme.domain.Person;
import net.jenshemme.domain.Project;
import net.jenshemme.instrumentation.AuthorizationInterceptor;
import net.jenshemme.instrumentation.LogInInterceptor;
import net.jenshemme.instrumentation.TracingInterceptor;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;

/**
 * The service to plan a house.
 * Created by jensomir on 12.01.15.
 */
@Stateless
public class HousePlanner {

    @PersistenceContext(unitName = "plousepu")
    EntityManager entityManager;

    @Inject
    Project project;

    @Inject
    ContextRegistry registry;

    @Interceptors(TracingInterceptor.class)
    public Project createProject(Person client, Person projectManager, House... houses) {
        project.setClient(client);
        project.setProjectManager(projectManager);
        if (houses == null) houses = new House[0];
        project.setHouses(Arrays.asList(houses));
        entityManager.persist(project);
        return project;
    }

    @Interceptors({TracingInterceptor.class, AuthorizationInterceptor.class})
    public Project updateProjectWithoutLogin(Project projectManipulator) {
        // merge given project into persistence context
        return project;
    }

    @Interceptors({LogInInterceptor.class, TracingInterceptor.class, AuthorizationInterceptor.class})
    public Project updateProject(Project projectManipulator) {
        // merge given project into persistence context
        return project;
    }
}
