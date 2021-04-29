package second

import spock.lang.Shared
import spock.lang.Specification

class TwoDotOneTest extends Specification {

    @Shared second = new TwoDotOne()

    def "findFiles"() {

        List<TraverseResult> res = second.findFiles('src\\main\\resources\\task_two_dot_one');

        expect:
        res && res.size() == 3

        and:
        res[0].name == "firstgroovy.txt"
        res[0].quantity == 2
        res[0].size == 6.46875

        and:
        res[1].name == "thirdgroovy.txt"
        res[1].quantity == 1
        res[1].size == 5.8515625

        and:
        res[2].name == "secondgroovy.txt"
        res[2].quantity == 2
        res[2].size == 591.181640625
    }
}
