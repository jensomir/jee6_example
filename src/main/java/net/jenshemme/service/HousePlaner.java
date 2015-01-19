package net.jenshemme.service;

import net.jenshemme.domain.House;
import net.jenshemme.domain.Person;
import net.jenshemme.domain.Project;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Arrays;

/**
 * The service to plan a house.
 * Created by jensomir on 12.01.15.
 */
@Stateless
public class HousePlaner {

    @Inject
    Project project;

    public Project createProject(Person client, Person projectManager, House... houses){
        project.setClient(client);
        project.setProjectManager(projectManager);
        project.setHouses(Arrays.asList(houses));
        return project;
    }
}
