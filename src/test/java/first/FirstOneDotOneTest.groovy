package first

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class FirstOneDotOneTest extends Specification {


    @Shared
            first = new FirstOneDotOne()

    def "findWordWithUpperCase"() {
        expect:
        first.findWordsOnlyWithLettersInLowerCase('First second Third fourth') == ['second', 'fourth']
    }

    def "findLettersFromOneIndexToSecond"() {
        expect:
        first.findLettersFromOneIndexToSecond('Teeeeeeeeeeeesttttttttts', 11, 16) == 'eesttt'

        and:
        first.findLettersFromOneIndexToSecond('test', 11, 16,) == ''

        and:
        first.findLettersFromOneIndexToSecond('test', 0, 3,) == 'test'
    }

    def "findEnglishLettersFromString"() {
        expect:
        first.findEnglishLettersFromString('РусEng') == 'ng'

        and:
        first.findEnglishLettersFromString('all') == 'all'

        and:
        first.findEnglishLettersFromString('ONe') == 'e'

        and:
        first.findEnglishLettersFromString('Пусто') == ''
    }

    def "makeFirstLitterToUpperCase"() {
        expect:
        first.makeFirstLitterToUpperCase('first second third') == ['First', 'Second', 'Third']

        and:
        first.makeFirstLitterToUpperCase('first') == ['First']

        and:
        first.makeFirstLitterToUpperCase('first  second') == ['First', 'Second']

        and:
        first.makeFirstLitterToUpperCase('first  second') == ['First', 'Second']
    }

    def "findPalinromes"() {
        expect:
        first.findPalinromes('first obo second ') == ['obo']

        and:
        first.findPalinromes('first obo second oto madam') == ['obo', 'oto', 'madam']

        and:
        first.findPalinromes('first obo madam') == ['obo', 'madam']

        and:
        first.findPalinromes('first o45bo second o345to mada123m qwertyytrewq') == []
    }

    def "isEmail"() {
        expect:
        first.isEmail('vasya@mail.com')

        and:
        first.isEmail('this is my email dave@gmail.com address')

        and:
        !first.isEmail('vasya@mail.c')

        and:
        !first.isEmail('vasyamail.c')
    }
}
