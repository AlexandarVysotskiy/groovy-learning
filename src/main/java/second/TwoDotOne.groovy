package second

import groovy.xml.MarkupBuilder


/**
 * 2.1. Просканировать заданную папку на диске. Найти все файлы, подпадающие под шаблон:
 * название файла (без учета расширения) заканчивается словом 'groovy'.
 * Результат поиска представить в виде списка записей и вывести его.
 *
 * 2.2. Вывести (представить) записи (полученный в результате работы предыдущей задачи)
 * в формате XML (see Groovy MarkupBuilder).
 */
class TwoDotOne {

//    2.1
    List<TraverseResult> findFiles(String path) {
        List<TraverseResult> res = []

        new File(path).traverse { file ->
            if (file.name.matches(~/.{0,}[gG]roovy\.[a-zA-Z0-9]+$+/)) {
                res.add(new TraverseResult(name: file.name, size: file.size() / 1024))
            }
        }

        res.collect {tr -> tr.setQuantity(findQuantity(res, tr.name))}

        res
    }

    private int findQuantity(List<TraverseResult> files, String name) {
        files.findAll{tr -> tr.name == name}.size()
    }

//    2.2
    String makeXml(List<TraverseResult> source) {
        def writer = new StringWriter()
        def xml = new MarkupBuilder(writer)
        xml.document {
            source.each { tr ->
                xml.traverseResult {
                    name(tr.name)
                    quantity(tr.quantity)
                    size(tr.size)
                }
            }
        }

        writer.toString()
    }
}
