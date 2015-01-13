package net.jenshemme.domain;

import java.util.Arrays;

/**
 * Describes a house.
 * Created by jensomir on 12.01.15.
 */
public class House {

    private Person owner;
    private byte[] buildingPlan;
    private Address buildingSite;

    public House(Person owner, byte[] buildingPlan, Address buildingSite) {
        this.owner = owner;
        this.buildingPlan = buildingPlan;
        this.buildingSite = buildingSite;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
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
                "owner=" + owner +
                ", buildingPlan=" + Arrays.toString(buildingPlan) +
                ", buildingSite=" + buildingSite +
                '}';
    }
}
