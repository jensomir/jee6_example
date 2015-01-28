package net.jenshemme.service;

import net.jenshemme.domain.Person;
import net.jenshemme.domain.Project;

/**
 * Implements the ProjectManipulator interface.
 */
public class ProjectManipulatorImpl implements ProjectManipulator {

    public static final Person dumbGuy = new Person("Guy", "Dumb");

    private Project project;

    public ProjectManipulatorImpl() {
        this.project = new Project();
    }

    @Override
    public void setRandomProjectManager() {
        this.project.setProjectManager(dumbGuy);
    }

    @Override
    public void setProjectManager(Person projectManager) {
        this.project.setProjectManager(projectManager);
    }

    @Override
    public Person getProjectManager() {
        return this.project.getProjectManager();
    }
}
