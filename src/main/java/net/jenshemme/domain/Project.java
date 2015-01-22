package net.jenshemme.domain;

import java.util.List;

/**
 * Extracted interface in order to demonstrate usage of Decorators.
 */
public interface Project {

    Person getClient();

    void setClient(Person client);

    Person getProjectManager();

    void setProjectManager(Person projectManager);

    List<House> getHouses();

    void setHouses(List<House> houses);

    void addHouse(House house);

    void setRandomProjectManager();
}
