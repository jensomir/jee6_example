package net.jenshemme.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * A house planning project.
 * Created by jensomir on 12.01.15.
 */
public class ProjectImpl implements Project {

    private Person client;
    private Person projectManager;
    private ArrayList<House> houses;

    public static final Person dumbGuy = new Person("Guy", "Dumb");

    public ProjectImpl() {
        houses = new ArrayList<>();
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
    public List<House> getHouses() {
        return houses;
    }

    @Override
    public void setHouses(List<House> houses) {
        this.houses = new ArrayList<>(houses);
    }

    @Override
    public void addHouse(House house) {
        this.houses.add(house);
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
