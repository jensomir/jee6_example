package net.jenshemme.instrumentation;

import net.jenshemme.domain.Person;
import net.jenshemme.domain.Project;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class ProjectTestDecorator implements Project {

    @Inject
    @Delegate
    @Any
    private Project project;

    public static final Person testGuy = new Person("Guy", "Test");

    @Override
    public void setRandomProjectManager() {
        System.out.println("TEST_DECORATED - TEST_DECORATED - TEST_DECORATED!!!");
        project.setProjectManager(testGuy);
    }


}
