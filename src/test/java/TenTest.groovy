import fourth.Person.Address
import spock.lang.Specification

class TenTest extends Specification {

    Map<String, Map<Integer, Address>> map

    def setup() {
        map = [
                'Grisha': [13: new Address('city': 'Mensk')],
                'Olya'  : [16: new Address('city': 'Brest')],
                'Masha' : [33: new Address('city': 'Grodno')],
                'Ura'   : [44: new Address('city': 'Vitebsk')]
        ]

        Map<String, Map<Integer, Address>> secondMap = [
                'Pasha': [35: new Address('city': 'Gomel')],
                'Erema': [99: new Address('city': 'Mogilev')]
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
            it.value.keySet()[0] > 20
        }

        Map lessFifty = map.findAll { it ->
            it.value.keySet()[0] < 50
        }

        then:
        moreTwenty.size() == 4
        lessFifty.size() == 5
    }
}
