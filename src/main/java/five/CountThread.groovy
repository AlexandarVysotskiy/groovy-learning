package five

class CountThread extends Thread {

    Count count
    int maxNumber
    int sleep

    CountThread(Count count, String threadName, int maxNumber, int sleepAmount) {
        this.count = count
        this.maxNumber = maxNumber
        setName(threadName)
        this.sleep = sleepAmount
    }

    @Override
    void run() {
        super.run()

        while (count.getValue() < maxNumber) {
            count.increment()
            println "Count is ${count.getValue()}, thread: ${getName()}"
            sleep(sleep)
        }
    }
}
