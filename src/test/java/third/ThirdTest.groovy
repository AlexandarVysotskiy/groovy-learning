package third

import spock.lang.Shared
import spock.lang.Specification

class ThirdTest extends Specification {

    @Shared third = new Third()

    private static final String path = 'src\\test\\resources\\third'
    private static final String newFileOne = '3216.dat'
    private static final String newFileTwo = '5432115.dat'

    def setup() {
        new File("src\\test\\resources").mkdir()
        new File(path).mkdir()
        new File("""${path}/123.txt""").createNewFile()
        new File("""${path}/12345.txt""").createNewFile()
    }

    def cleanup() {
       new File(path).deleteDir()
    }

    def "find"() {
        File[] result = third.find(path)

        expect:
        !result.toList().isEmpty()

        and:
        result[0].name == newFileOne

        and:
        result[1].name == newFileTwo
    }
}
