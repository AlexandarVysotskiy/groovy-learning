package eight

class HelloEngine {


    static void main(String[] args) {
        hello()
    }

    static String hello() {
        "Hello, ${new ScriptForImport().message}"
    }
}
