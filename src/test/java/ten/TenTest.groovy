package ten

import fourth.Person.Address
import spock.lang.Specification

class TenTest extends Specification {

    Map map

    def setup() {
        map = [
                'Grisha': [age: 13, address: 'str. Surganova 18, Mensk'],
                'Olya'  : [age: 16, address: 'str. Gogolya 44, Brest'],
                'Masha' : [age: 33, address: 'str. Pushkina 51, Grodno'],
                'Ura'   : [age: 44, address: 'str. Kolasa 33, Vitebsk']
        ]

        Map secondMap = [
                'Pasha': [age: 35, address: 'srt. Kupaly 21, Gomel'],
                'Erema': [age: 99, address: 'str. Gagarina 22, Mogilev']
        ]

        map.putAll(secondMap)
    }


    def "addOneElementTest"() {
        given:
        Map ageAddress = [24: new Address('city': 'Mozar')]

        expect:
        map.size() == 6

        when:
        map['Peter'] = ageAddress

        then:
        map.size() == 7
        map.Peter == ageAddress
        map.get('Peter') == ageAddress
    }

    def "removeOneElementTest"() {
        given:
        Map ageAddress = [24: new Address('city': 'Mozar')]
        map['Peter'] = ageAddress

        expect:
        map.size() == 7

        when:
        map.remove('Peter')

        then:
        map.size() == 6
        map.get('Peter') == null
    }

    def "findPersonAge"() {
        when:
        Map moreTwenty = map.findAll { it ->
            it.value.get('age') > 20
        }

        Map lessFifty = map.findAll { it ->
            it.value.get('age') < 50
        }

        then:
        moreTwenty.size() == 4
        lessFifty.size() == 5
    }
}
