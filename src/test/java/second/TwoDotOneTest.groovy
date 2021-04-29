package second

import spock.lang.Shared
import spock.lang.Specification

class TwoDotOneTest extends Specification {

    @Shared second = new TwoDotOne()

    def "findFiles"() {

        second.findFiles('src\\main\\resources\\task_two_dot_one')

        expect:
        second != null
    }
}
