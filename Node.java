package crudEstrutura;

public class Node {
    String firstName;
    String lastName;
    String birthDay;
    String phoneNumber;

    Node next;

    public Node(String firstName, String lastName, String birthDay, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;

        Node next = null;
    }

}