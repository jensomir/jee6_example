package net.jenshemme.instrumentation;

import net.jenshemme.domain.Person;
import net.jenshemme.service.ProjectManipulator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

/**
 * The decorator. It only intercepts on usage of method 'setProjectManager(...)'.
 */
@Decorator
public abstract class ProjectManipulatorDecorator implements ProjectManipulator {

    @Inject
    @Delegate
    @Any
    private ProjectManipulator projectManipulator;

    public static final Person cleverGuy = new Person("Guy", "Clever");

    @Override
    public void setRandomProjectManager() {
        projectManipulator.setProjectManager(cleverGuy);
    }
}
