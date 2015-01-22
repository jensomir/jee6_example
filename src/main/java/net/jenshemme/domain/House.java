package net.jenshemme.domain;

import java.util.Arrays;

/**
 * Describes a house.
 * Created by jensomir on 12.01.15.
 */
public class House {

    private byte[] buildingPlan;
    private Address buildingSite;

    public House(byte[] buildingPlan, Address buildingSite) {
        this.buildingPlan = buildingPlan;
        this.buildingSite = buildingSite;
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
