package net.jenshemme.domain;

import java.util.Collection;

/**
 * Extracted interface in order to demonstrate usage of Decorators.
 */
public interface Project {

    Person getClient();

    void setClient(Person client);

    Person getProjectManager();

    void setProjectManager(Person projectManager);

    Collection<House> getHouses();

    void setHouses(Collection<House> houses);

    void setRandomProjectManager();
}
