package five

import spock.lang.Specification

class CountThreadTest extends Specification {

    def "countTest"() {
        Count count = new Count()

        synchronized (count) {
        }

        int maxNumber = 20

        List<CountThread> threadList = []

        for (int i = 1; i <= 10; i++) {
            threadList << new CountThread(count, i.toString(), maxNumber, 100)
        }

        threadList.each { it.start() }
        threadList.each { it.join() }

        sleep(maxNumber * 100)

        expect:
        count.getValue() == maxNumber
    }
}
