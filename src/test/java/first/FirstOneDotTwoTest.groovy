package first

import spock.lang.Shared
import spock.lang.Specification

class FirstOneDotTwoTest extends Specification {

    @Shared
            first = new FirstOneDotTwo()

    def "findDifferenceNumberAmount"() {
        expect:
        first.findDifferenceNumberAmount(10, 10, 10, 3, 5, 0) == 4

        and:
        first.findDifferenceNumberAmount() == 0
    }

    def "findMaxAndMinNumber"() {
        expect:
        first.findMaxAndMinNumber(10, 10, 10, 3, 5, 0) == [0, 10]

        and:
        first.findMaxAndMinNumber(1) == [1, 1]

        and:
        first.findMaxAndMinNumber() == []
    }

    def "increase"() {
        expect:
        first.increase([-1, -2, 3, 4]) == [-3, -6, 6, 8]

        and:
        first.increase([-1, -2, 0, 4]) == [-3, -6, 0, 8]

        and:
        first.increase([-1, -2, 0, -4]) == [-3, -6, 0, -12]

        and:
        first.increase([]) == []

        and:
        first.increase([4, 5, 6]) == [8, 10, 12]
    }

    def "containsNumbers"() {
        expect:
        first.containsNumbers([1, 2, 3, 4], [1, 2, 3, 4]) == [1, 2, 3, 4]

        and:
        first.containsNumbers([1, 2, 3, 4], [3, 4]) == [3, 4]

        and:
        first.containsNumbers([1, 2, 3, 4], [5, 6, 7, 8]) == []
    }
}
