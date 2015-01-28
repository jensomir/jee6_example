package net.jenshemme.service;

import net.jenshemme.domain.Person;

/**
 * Extracted interface in order to demonstrate usage of Decorators.
 */
public interface ProjectManipulator {

    void setRandomProjectManager();

    void setProjectManager(Person projectManager);

    Person getProjectManager();
}
