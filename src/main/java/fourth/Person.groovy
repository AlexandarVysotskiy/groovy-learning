package fourth

import groovy.transform.EqualsAndHashCode


class Person {

    String firstName
    String surName
    Address address
    int age

    @Override
    String toString() {
        "First name is: ${firstName} and surname is: ${surName}"
    }

    Person plus(Person person) {
        return new Person('firstName': "${this.firstName} + ${person.firstName}",
                'age': this.age + person.age)
    }

    Person minus(Person person) {
        return new Person('firstName': "${this.firstName} - ${person.firstName}",
                'age': this.age - person.age)
    }

    @EqualsAndHashCode
    static class Address {

        Address() {
        }

        Address(String city, String street, int index) {
            this.city = city
            this.street = street
            this.index = index
        }
        String city
        String street
        int index
    }
}
