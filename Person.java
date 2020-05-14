package crudEstrutura;

public class Person {
    int id;
    String firstName;
    String lastName;
    String birthDay;
    String phoneNumber;

    Person next;

    public Person(int id, String firstName, String lastName, String birthDay, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;

        Person next = null;
    }

}