package second

class TwoDotOne {

    void findFiles(def path) {
        def dir = new File(path)

        dir.traverse { file ->
            if (file.name.contains('groovy.')) {
                println """
                        *Name: ${file.name}*

                        *Quantity: ${
                    file.getParentFile().listFiles()
                            .inject([]) { res, it ->
                        if (it.name.contains('groovy.')) {
                            res << it
                        }
                        res
                    }.size()
                }*

                        *Size: ${file.size() / 1024}*
                      """
            }
        }
    }
}
