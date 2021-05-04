package seventh

import fourth.Person

class Seventh {

    static int power(int to, int of) {
        to**of
    }

    static Closure printIfNotNull = { object ->
        object != null ? object : 'no value'
    }

    static List<Integer> getPersonIndices(List<Person> personList) {
        personList.findAll { Person p ->
            p.getAddress()?.getIndex() != 0 && p.getAddress()?.getIndex() != null
        }*.getAddress()*.getIndex()
    }
}
