package five

class Count {

    int value

    synchronized void increment() {
        this.value++
    }

    synchronized int getValue() {
        return this.value
    }
}
