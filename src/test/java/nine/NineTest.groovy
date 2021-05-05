package nine

import groovy.xml.MarkupBuilder
import spock.lang.Specification

class NineTest extends Specification {

    final static File XML_FILE = new File('text.xml')

    def setup() {
        def writer = new StringWriter()
        def mb = new MarkupBuilder(writer)
        def fw = new FileWriter(XML_FILE)

        mb.xml {
            for (int amountUnusualValue = 0; amountUnusualValue < 10; amountUnusualValue++) {
                for (int amountUsualValue = 0; amountUsualValue <= 100_000; amountUsualValue++) {
                    mb.field(name: amountUsualValue) {
                        value(amountUsualValue)
                    }
                }
                mb.field(name: amountUnusualValue) {
                    value('unusual value')
                }
            }
        }

        fw.write(writer.toString())

        fw.close()
    }

    def cleanup() {
        XML_FILE.delete()
    }

    def "test"() {
        expect:
        Nine.findValue(XML_FILE, 'unusual value') == 10
    }
}
