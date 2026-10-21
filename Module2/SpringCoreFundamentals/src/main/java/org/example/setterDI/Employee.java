package org.example.setterDI;

public class Employee {
    private Address address;

    public void setAddress(Address address) {
        this.address = address;
    }

    public void displayAddress(){
        address.getAddress();
    }
}
