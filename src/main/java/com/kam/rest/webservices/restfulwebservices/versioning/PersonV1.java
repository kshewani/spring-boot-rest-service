package com.kam.rest.webservices.restfulwebservices.versioning;

public class PersonV1 {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public PersonV1(String name) {
        this.name = name;
    }
}
