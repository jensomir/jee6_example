package net.jenshemme.domain;

import java.util.Arrays;
import java.util.Collection;

/**
 * A house planning project.
 * Created by jensomir on 12.01.15.
 */
public class Project {

    private Person client;
    private Person projectManager;
    private Collection<House> houses;

    public Project(Person client, Person projectManager, House... houses) {
        this.client = client;
        this.projectManager = projectManager;
        this.houses = Arrays.asList(houses);
    }

    public Person getClient() {
        return client;
    }

    public void setClient(Person client) {
        this.client = client;
    }

    public Person getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(Person projectManager) {
        this.projectManager = projectManager;
    }

    public Collection<House> getHouses() {
        return houses;
    }

    public void setHouses(Collection<House> houses) {
        this.houses = houses;
    }

    @Override
    public String toString() {
        return "Project{" +
                "client=" + client +
                ", projectManager=" + projectManager +
                ", houses=" + houses +
                '}';
    }
}
