package fourth

import fourth.Person.Address
import spock.lang.Specification

/**
 * 4.3. Написать класс Person (с некоторым набором свойств,
 * к примеру firstName, surName, address (city, street, index) , age);
 *
 * Определить для объектов класса методы '+', '-';
 * Определить метод toString, который выводит "${firstName}, ${surName}"
 * Среди объектов типа Person найти такие, у которых возраст (age) менее 30 лет;
 * Вывести все различные адреса, которые есть у списка объектов Person;
 * Переопределить метод toString, не меняя описания класса Person
 * (к примеру теперь пусть выводит "${surName} ${firstName} (${age})").
 */
class FourthDotThree extends Specification {

    Person first
    Person second
    Person third
    Person fourth
    Person fifth

    def personList

    def setup() {
        first = new Person(firstName: 'John', surName: 'Wick',
                address: new Person.Address(city: 'Mensk', street: 'Garden', index: 123), 'age': 33)

        second = new Person(firstName: 'Vasya', surName: 'Pupkin',
                address: new Person.Address(city: 'Brest', street: 'Gogolya', index: 99), 'age': 55)

        third = new Person(firstName: 'Eva', surName: 'Adam',
                address: new Person.Address(city: 'Grodno', street: 'Pushkina', index: 22), 'age': 22)

        fourth = new Person(firstName: 'Nina', surName: 'Vasyna',
                address: new Person.Address(city: 'Moscow', street: 'First', index: 111), 'age': 18)

        fifth = new Person(firstName: 'Olya', surName: 'Vasyna',
                address: new Person.Address(city: 'Moscow', street: 'First', index: 111), 'age': 19)

        personList = new ArrayList()
        personList.add(first)
        personList.add(second)
        personList.add(third)
        personList.add(fourth)
        personList.add(fifth)
    }

    def "FirstTest"() {
        List<Address> uniqueListAddress = personList.collect { Person p -> p.address }.unique()

        def newFromPlus = fifth + second
        def newFromMinus = third - fourth

        expect:
        newFromPlus.firstName == 'Olya + Vasya'
        newFromPlus.age == 74

        and:
        newFromMinus.firstName == 'Eva - Nina'
        newFromMinus.age == 4

        and:
        first.toString() == ("First name is: ${first.firstName} and surname is: ${first.surName}")
        second.toString() == ("First name is: ${second.firstName} and surname is: ${second.surName}")
        third.toString() == ("First name is: ${third.firstName} and surname is: ${third.surName}")

        and:
        personList.findAll { it -> it.age < 30 }[0].equals(third)
        personList.findAll { it -> it.age < 30 }[1].equals(fourth)
        personList.findAll { it -> it.age < 30 }[2].equals(fifth)

        and:
        uniqueListAddress.size() == 4
        uniqueListAddress[0] == first.address
        uniqueListAddress[1] == second.address
        uniqueListAddress[2] == third.address
        uniqueListAddress[3] == fifth.address
    }

    def "SecondTest"() {
        fifth.metaClass.toString = {-> "${surName} ${firstName} (${age})"}

        expect:
        fifth.toString() == 'Vasyna Olya (19)'
    }
}
