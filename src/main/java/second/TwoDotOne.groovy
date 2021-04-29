package second

class TwoDotOne {

    List<TraverseResult> findFiles(def path) {
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
}
