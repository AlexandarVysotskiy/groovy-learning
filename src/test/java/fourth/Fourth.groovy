package fourth

import spock.lang.Specification

/**
 * 4.1. Добавить к классу Integer и интерфейсу List несколько методов (один из них должен быть статическим),
 * используя возможности метапрограммирования в Groovy;
 */
class Fourth extends Specification {

//    4.1
    def "AddMethodsToInteger"() {

        int i = 0

        Integer.metaClass.hello {
            "Hello I am ${i.getClass()}"
        }

        Integer.metaClass.static.helloStaticMethod << {
            'Hello this is static method'
        }

        expect:
        i.hello() == 'Hello I am class java.lang.Integer'

        and:
        i.helloStaticMethod() == 'Hello this is static method'
    }

//    4.1
    def "AddMethodsToList"() {

        def list = new ArrayList()

        List.metaClass.isRealEmptyList { ->
            if (delegate.size() == 0) {
                'Yeas this list is real empty'
            } else {
                "Yeas this list is't empty"
            }
        }

        List.metaClass.static.justMessage << {
            'Just message'
        }

        expect:
        list.isRealEmptyList() == 'Yeas this list is real empty'

        and:
        list.add(1)
        list.isRealEmptyList() == 'Yeas this list is\'t empty'

        and:
        list.justMessage() == 'Just message'
    }

    /**
     * 4.2. Задать объект, типа Closure, который принимает несколько параметров
     *      (Integer, String, Closure). Затем вызвать closure явным и неявным образом.
     */
    def "CreateClosure"() {
        def myClosure = { int i, String s, Closure c ->
            """First: ${i}, second: ${s}, third: ${c}"""
        }

//      не явный вызов замыкания
        expect:
        myClosure(123, 'My string', { -> 'Closure'
        }) == "First: 123, second: My string, third: Closure"

//      явный вызов замыкания
        and:
        myClosure.call(123, 'My string', { -> 'Closure'
        }) == "First: 123, second: My string, third: Closure"
    }
}
