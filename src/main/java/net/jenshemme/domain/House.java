package net.jenshemme.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.UUID;

/**
 * Describes a house.
 * Created by jensomir on 12.01.15.
 */
@Entity
@Table(name = "HOUSE")
public class House implements Serializable {

    @Id
    String id;

    @Lob
    private byte[] buildingPlan;

    @OneToOne
    private Address buildingSite;

    public House() {
        id = UUID.randomUUID().toString();
    }

    public House(byte[] buildingPlan, Address buildingSite) {
        this.buildingPlan = buildingPlan;
        this.buildingSite = buildingSite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte[] getBuildingPlan() {
        return buildingPlan;
    }

    public void setBuildingPlan(byte[] buildingPlan) {
        this.buildingPlan = buildingPlan;
    }

    public Address getBuildingSite() {
        return buildingSite;
    }

    public void setBuildingSite(Address buildingSite) {
        this.buildingSite = buildingSite;
    }

    @Override
    public String toString() {
        return "House{" +
                "buildingPlan=" + Arrays.toString(buildingPlan) +
                ", buildingSite=" + buildingSite +
                '}';
    }
}
