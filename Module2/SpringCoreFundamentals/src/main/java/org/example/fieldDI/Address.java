package org.example.fieldDI;

import org.springframework.stereotype.Component;

@Component
public class Address {

    public String getAddress() {
        return "Address is: 123 Main St, Anytown, USA";
    }
}