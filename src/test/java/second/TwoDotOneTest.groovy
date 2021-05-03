package second

import spock.lang.Shared
import spock.lang.Specification

class TwoDotOneTest extends Specification {

    @Shared
            second = new TwoDotOne()
    @Shared
            res = second.findFiles('src\\main\\resources\\task_two_dot_one');

//    2.1
    def "findFiles"() {
        expect:
        res && res.size() == 5

        and:
        res[0].name == "firstgroovy.txt"
        res[0].quantity == 1
        res[0].size == 6.46875

        and:
        res[1].name == "groovy.java"
        res[1].quantity == 2
        res[1].size == 0.0

        and:
        res[2].name == "thirdgroovy.txt"
        res[2].quantity == 1
        res[2].size == 5.8515625

        and:
        res[3].name == "groovy.java"
        res[3].quantity == 2
        res[3].size == 0.0

        and:
        res[4].name == "secondgroovy.txt"
        res[4].quantity == 1
        res[4].size == 591.181640625
    }

//    2.2
    def "makeXml"() {

        String xml = """<document>
  <traverseResult>
    <name>firstgroovy.txt</name>
    <quantity>1</quantity>
    <size>6.46875</size>
  </traverseResult>
  <traverseResult>
    <name>groovy.java</name>
    <quantity>2</quantity>
    <size>0.0</size>
  </traverseResult>
  <traverseResult>
    <name>thirdgroovy.txt</name>
    <quantity>1</quantity>
    <size>5.8515625</size>
  </traverseResult>
  <traverseResult>
    <name>groovy.java</name>
    <quantity>2</quantity>
    <size>0.0</size>
  </traverseResult>
  <traverseResult>
    <name>secondgroovy.txt</name>
    <quantity>1</quantity>
    <size>591.181640625</size>
  </traverseResult>
</document>"""

        expect:
        second.makeXml(res).equals(xml)
    }
}
