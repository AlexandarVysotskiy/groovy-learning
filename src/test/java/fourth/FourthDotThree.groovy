package fourth

import fourth.Person.Address
import spock.lang.Shared
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

    @Shared
    Person first
    @Shared
    Person second
    @Shared
    Person third
    @Shared
    Person fourth
    @Shared
    Person fifth

    @Shared
    List<Person> personList

    def setupSpec() {
        personList = [
                first = new Person(firstName: 'John', surName: 'Wick',
                        address: new Address(city: 'Mensk', street: 'Garden', index: 123), 'age': 33),

                second = new Person(firstName: 'Vasya', surName: 'Pupkin',
                        address: new Address(city: 'Brest', street: 'Gogolya', index: 99), 'age': 55),

                third = new Person(firstName: 'Eva', surName: 'Adam',
                        address: new Address(city: 'Grodno', street: 'Pushkina', index: 22), 'age': 22),

                fourth = new Person(firstName: 'Nina', surName: 'Vasyna',
                        address: new Address(city: 'Moscow', street: 'First', index: 111), 'age': 18),

                fifth = new Person(firstName: 'Olya', surName: 'Vasyna',
                        address: new Address(city: 'Moscow', street: 'First', index: 111), 'age': 19)
        ]
    }

    def "FirstTest"() {
        when:
        def newFromPlus = fifth + second
        def newFromMinus = third - fourth

        then:
        newFromPlus.firstName == 'Olya + Vasya'
        newFromPlus.age == 74

        and:
        newFromMinus.firstName == 'Eva - Nina'
        newFromMinus.age == 4

        and:
        first.toString() == ("First name is: John and surname is: Wick")
        second.toString() == ("First name is: Vasya and surname is: Pupkin")
        third.toString() == ("First name is: Eva and surname is: Adam")
    }

    def "UniqueAddressTest"() {
        given:
        List<Address> uniqueListAddress = personList.collect { Person p -> p.address }

        when:
        uniqueListAddress.unique()

        then:
        uniqueListAddress.size() == 4
        uniqueListAddress[0] == first.address
        uniqueListAddress[1] == second.address
        uniqueListAddress[2] == third.address
        uniqueListAddress[3] == fifth.address
    }

    def "FindAgeTest"() {
        when:
        List<Person> lessThirtyYearsPersons = personList.findAll { it -> it.age < 30 }

        then:
        lessThirtyYearsPersons[0].equals(third)
        lessThirtyYearsPersons[1].equals(fourth)
        lessThirtyYearsPersons[2].equals(fifth)
    }

    def "SecondTest"() {
        given:
        fifth.metaClass.toString = { -> "${surName} ${firstName} (${age})" }

        expect:
        fifth.toString() == 'Vasyna Olya (19)'
    }
}
