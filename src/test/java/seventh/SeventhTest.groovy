package seventh

import fourth.Person
import spock.lang.Specification

/**
 * 7.1. Операторы:
 *
 * Возвести число 4 в 5 степень;
 * Написать closure printValue,которое если аргумент не null выводит его значение,
 * иначе выводит 'no value'(без оператора 'if')
 *
 * У каждого объекта Person вывести значение index (свойство адреса),
 * учитывая что у некоторых объектов Person адреса нету (без оператора 'if')
 */
class SeventhTest extends Specification {

    Person first
    Person second
    Person third
    Person fourth
    Person fifth
    Person sixth
    Person seventh

    List<Person> personList;

    def setup() {
        personList = [
                first = new Person(firstName: 'John', surName: 'Wick',
                        address: new Person.Address(city: 'Mensk', street: 'Garden', index: 123), 'age': 33),

                second = new Person(firstName: 'Vasya', surName: 'Pupkin',
                        address: new Person.Address(city: 'Brest', street: 'Gogolya', index: 99), 'age': 55),

                third = new Person(firstName: 'Eva', surName: 'Adam',
                        address: new Person.Address(city: 'Grodno', street: 'Pushkina'), 'age': 22),

                fourth = new Person(firstName: 'Nina', surName: 'Vasyna',
                        address: new Person.Address(city: 'Moscow', street: 'First', index: 111), 'age': 18),

                fifth = new Person(firstName: 'Olya', surName: 'Vasyna',
                        address: new Person.Address(city: 'Moscow', street: 'First'), 'age': 19),

                sixth = new Person(firstName: 'Olya', surName: 'Vasyna', 'age': 19),

                seventh = new Person(firstName: 'Olya', surName: 'Vasyna',
                        address: new Person.Address(city: 'Moscow', street: 'First', index: 0), 'age': 19)
        ]
    }

    def "PowerTest"() {
        expect:
        Seventh.power(4, 5) == 1024
        Seventh.power(3, 2) == 9
        Seventh.power(10, 3) == 1000
        Seventh.power(2, 2) != 5
    }

    def "NotNullPrint"() {
        expect:
        Seventh.printIfNotNull(0) == 0
        Seventh.printIfNotNull(new Person().getAddress()) == 'no value'
        Seventh.printIfNotNull('') == ''
        Seventh.printIfNotNull('TestString') == 'TestString'
    }

    def "GetPersonIndices"() {
        List<Integer> indices = Seventh.getPersonIndices(personList)

        expect:
        indices.size() == 3
        indices[0] == 123
        indices[1] == 99
        indices[2] == 111
    }
}
