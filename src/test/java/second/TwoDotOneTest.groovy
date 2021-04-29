package second

import spock.lang.Shared
import spock.lang.Specification

class TwoDotOneTest extends Specification {

    @Shared
            second = new TwoDotOne()
    @Shared
            res = second.findFiles('src\\main\\resources\\task_two_dot_one');

    def "findFiles"() {
        expect:
        res && res.size() == 3

        and:
        res[0].name == "firstgroovy.txt"
        res[0].quantity == 2
        res[0].size == 6.46875

        and:
        res[1].name == "thirdgroovy.txt"
        res[1].quantity == 1
        res[1].size == 5.8515625

        and:
        res[2].name == "secondgroovy.txt"
        res[2].quantity == 2
        res[2].size == 591.181640625
    }

    def "makeXml"() {

        String xml = """<traverseResult>
  <name>firstgroovy.txt</name>
  <quantity>2</quantity>
  <size>6.46875</size>
</traverseResult>
<traverseResult>
  <name>thirdgroovy.txt</name>
  <quantity>1</quantity>
  <size>5.8515625</size>
</traverseResult>
<traverseResult>
  <name>secondgroovy.txt</name>
  <quantity>2</quantity>
  <size>591.181640625</size>
</traverseResult>"""

        expect:
        second.makeXml(res).equals(xml)
    }
}
