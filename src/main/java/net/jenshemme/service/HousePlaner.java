package net.jenshemme.service;

import net.jenshemme.domain.House;
import net.jenshemme.domain.Person;
import net.jenshemme.domain.Project;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;

/**
 * The service to plan a house.
 * Created by jensomir on 12.01.15.
 */
@Stateless
public class HousePlaner {

    public Project createProject(Person client, Person projectManager, House... houses){
        return new Project(client, projectManager, houses);
    }
}
