package net.jenshemme.instrumentation;

import net.jenshemme.domain.Person;
import net.jenshemme.domain.Project;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

/**
 * The decorator. It only intercepts on usage of method 'setProjectManager(...)'.
 */
@Decorator
public abstract class ProjectDecorator implements Project {

    @Inject
    @Delegate
    @Any
    private Project project;

    public static final Person cleverGuy = new Person("Guy", "Clever");

    @Override
    public void setRandomProjectManager() {
        System.out.println("DECORATED - DECORATED - DECORATED!!!");
        project.setProjectManager(cleverGuy);
    }
}
