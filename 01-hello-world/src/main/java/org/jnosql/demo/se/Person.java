package org.jnosql.demo.se;

public record Person(String id, String name, Integer age) {


    public static Person of(String name, Integer age){
        return new Person(null, name, age);
    }
}
