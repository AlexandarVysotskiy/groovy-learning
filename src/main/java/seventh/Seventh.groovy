package seventh

import fourth.Person

class Seventh {

    static int power(int to, int of) {
        Math.pow(to, of)
    }

    static Closure<String> printIfNotNull = { object ->
        object ? object.toString() : 'no value'
    }

    static List<Integer> getPersonIndices(List<Person> personList) {
        personList
                .findAll { Person p -> p.getAddress().getIndex() > 0 }
                .collect { Person p -> p.getAddress().getIndex() > 0 }
    }
}
