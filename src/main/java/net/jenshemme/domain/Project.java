package net.jenshemme.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * A house planning project.
 * Created by jensomir on 12.01.15.
 */
@Entity
@Table(name = "PROJECT")
public class Project implements Serializable {

    @Id
    private String id;

    @OneToOne
    private Person client;

    @OneToOne
    private Person projectManager;

    @OneToMany
    private List<House> houses;

    public Project() {
        id = UUID.randomUUID().toString();
        houses = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = new ArrayList<>(houses);
    }

    public void addHouse(House house) {
        this.houses.add(house);
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
