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
        List<TraverseResult> res = new ArrayList<>();

        new File(path).traverse { file ->
            if (file.name ==~ /.+?[gG]roovy.+/) {
                res.add(new TraverseResult(file.name, findQuantity(file), file.size() / 1024))
            }
        }

        res
    }

    private int findQuantity(File file) {
        file.getParentFile().listFiles().inject([]) { res, it ->
            if (it.name.contains('groovy.')) {
                res << it
            }
            res
        }.size()
    }

//    2.2
    String makeXml(List<TraverseResult> source) {
        def writer = new StringWriter()
        def xml = new MarkupBuilder(writer)

        source.each { tr ->
            xml.traverseResult {
                name(tr.name)
                quantity(tr.quantity)
                size(tr.size)
            }
        }

        writer.toString()
    }
}
