package five

import spock.lang.Specification

class CountThreadTest extends Specification {

    def "countTest"() {
        Count count = new Count()

        int maxNumber = 10
        int sleepTime = 100

        List<Thread> threadList = []

        for (int i = 1; i <= maxNumber; i++) {
            threadList << Thread.start {
                println "Thread: ${Thread.currentThread().getName()}, value before icreamenting: ${count.getValue()}"
                count.increment()
                println "Thread: ${Thread.currentThread().getName()}, value after icreamenting: ${count.getValue()}"
                sleep(sleepTime)
            }
        }

        threadList.each { it.join() }

        expect:
        count.getValue() == maxNumber
    }
}

