package net.jenshemme.domain;

import java.util.Collection;

/**
 * A house planning project.
 * Created by jensomir on 12.01.15.
 */
public class ProjectImpl implements Project {

    private Person client;
    private Person projectManager;
    private Collection<House> houses;

    public static final Person dumbGuy = new Person("Guy", "Dumb");

    public ProjectImpl() {
    }

    @Override
    public Person getClient() {
        return client;
    }

    @Override
    public void setClient(Person client) {
        this.client = client;
    }

    @Override
    public Person getProjectManager() {
        return projectManager;
    }

    @Override
    public void setProjectManager(Person projectManager) {
        this.projectManager = projectManager;
    }

    @Override
    public Collection<House> getHouses() {
        return houses;
    }

    @Override
    public void setHouses(Collection<House> houses) {
        this.houses = houses;
    }

    @Override
    public void setRandomProjectManager() {
        this.setProjectManager(dumbGuy);
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
