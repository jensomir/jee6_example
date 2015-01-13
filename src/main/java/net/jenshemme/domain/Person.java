package net.jenshemme.domain;

/**
 * Describes a person.
 * Created by jensomir on 12.01.15.
 */
public class Person {

    private String lastName;
    private String name;

    public Person(String lastName, String name) {
        this.lastName = lastName;
        this.name = name;
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
