package org.example.ConstructorDI;

public class Employee {
    private Address address;

    public Employee(Address address) {
        this.address = address;
    }

    public void showAddress() {
        address.getAddress();
    }
}
