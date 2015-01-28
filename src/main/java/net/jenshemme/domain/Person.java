package net.jenshemme.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

/**
 * Describes a person.
 * Created by jensomir on 12.01.15.
 */
@Entity
@Table(name = "PERSON")
public class Person implements Serializable {

    @Id
    private String id;

    private String lastName;
    private String name;

    public Person() {
        id = UUID.randomUUID().toString();
    }

    public Person(String lastName, String name) {
        this.lastName = lastName;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
