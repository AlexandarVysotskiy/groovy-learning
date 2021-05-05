package eight

import spock.lang.Specification

class Eight extends Specification {

    List<Integer> list

    def setup() {
        list = [1, 2, 3, 4]
    }

    //minus: no cashing
    def "evalTest"() {
        expect:
        Eval.me("3**3") == 27
        Eval.me("list", list, "list.find{it > 3}") == 4
    }

    def "groovyShellTest"() {
        given:
        GroovyShell shell = new GroovyShell()

        when:
        Object sumResult = shell.evaluate("3 + 5")
        List listFromScript = (List) shell.evaluate("[1,2,3,4]")

        then:
        8 == sumResult
        list == listFromScript
    }

    def "groovyShellSharingDataTest"() {
        given:
        Binding sharedData = new Binding()
        GroovyShell shell = new GroovyShell(sharedData)
        ArrayList<String> splitResult = ["split", "string"]

        when:
        sharedData.setProperty("list", this.list)
        sharedData.setVariable("s", "split-string")
        shell.evaluate("name='Peter'")

        then:
        "Peter" == shell.getProperty("name")
        1 == shell.evaluate("list.find{it < 3}")
        splitResult == shell.evaluate("s.split('-').toList()")
    }

    def "groovyClassLoaderTest"() throws Exception {
        given:
        final GroovyClassLoader loader = new GroovyClassLoader()
        final Class first = loader.parseClass("class First { String helloFirst() { 'Hello first' } }")

        expect:
        "First" == first.getName()
        "Hello first" == first.getMethod("helloFirst").invoke(first.newInstance(), null)
    }

    def "groovyScriptEngineTest"() throws Exception {
        given:
        final Class script = new GroovyScriptEngine("src/main/java/eight/").loadScriptByName("HelloEngine.groovy")

        expect:
        "Hello, this is importing script" == script.hello()
    }

    def "groovyScriptArrayProcess"() throws Exception {
        given:
        final GroovyScriptEngine engine = new GroovyScriptEngine("src/main/java/eight/")
        final Binding binding = new Binding()

        when:
        binding.setVariable("salaryList", [1500, 2000, 3000, 5000])

        then:
        5000 == engine.run("HelloEngine.groovy", binding)
    }
}
