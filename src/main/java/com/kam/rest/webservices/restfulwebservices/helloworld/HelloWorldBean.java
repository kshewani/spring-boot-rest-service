package com.kam.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {

    private final String message;

    public HelloWorldBean(String messsage) {
        this.message = messsage;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return String.format("HelloWorldBean [message=%s]", message);
    }
}
