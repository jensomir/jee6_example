package net.jenshemme.instrumentation;

import net.jenshemme.domain.Person;
import net.jenshemme.service.ProjectManipulator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class ProjectManipulatorTestDecorator implements ProjectManipulator {

    @Inject
    @Delegate
    @Any
    private ProjectManipulator projectManipulator;

    public static final Person testGuy = new Person("Guy", "Test");

    @Override
    public void setRandomProjectManager() {
        projectManipulator.setProjectManager(testGuy);
    }


}
