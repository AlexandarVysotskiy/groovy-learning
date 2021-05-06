package nine

import groovy.util.slurpersupport.GPathResult

/**
 * 9.1. Чтение больших файлов: eсть большой xml файл - 1 GB Структуры
 * <xml>
 * <field name="SOME NAME">
 * SOME Value
 * </field>
 * .....
 * </xml>
 *
 * Необходимо пройтись по нему и найти количество полей (field),
 * значение которых соответствует введенному значению.
 */
class Nine {

    static int findValue(File file, String findValue) {
        int count = 0

        file.eachLine { lineValue, lineNumber ->
            if (lineValue.contains(findValue)) {
                count++
            }
        }

        count
    }

    static int findValueUseGroovyMethods(File file, String findValue) {
        GPathResult xml = new XmlSlurper().parse(file)

        xml.'*'.findAll { node ->
            node.text() == findValue
        }*.text().size()
    }
}
