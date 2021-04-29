package second

import groovy.xml.MarkupBuilder

class TwoDotOne {

    List<TraverseResult> findFiles(String path) {
        List<TraverseResult> res = new ArrayList<>();

        new File(path).traverse { file ->
            if (file.name.contains('groovy.txt')) {
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
