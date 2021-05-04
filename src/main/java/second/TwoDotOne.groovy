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

        List<File> foldersList = []

        new File(path).eachFile { file ->
            if (file.getName().matches(~/.{0,}[gG]roovy\.[a-zA-Z0-9]+$+/)) {
                res.add(new TraverseResult(name: file.name, size: file.size() / 1024))
            } else if (file.directory) {
                foldersList << file
            }
        }

        List<String> onlyFileNamesList = res.collect { it.name }

        foldersList.each {
            it.eachFile { file ->
                if (onlyFileNamesList.contains(file.name)) {
                    res.add(new TraverseResult(name: file.name, size: file.size() / 1024))
                }
            }
        }

        res.each { tr ->
            List<TraverseResult> duplicate = findDuplicate(res, tr.name)
            tr.setQuantity(duplicate.size())
            tr.setSize(duplicate.collect { it.size }.sum())
        }

        res.unique()
    }

    private List<TraverseResult> findDuplicate(List<TraverseResult> files, String name) {
        files.findAll { tr -> tr.name == name }
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
