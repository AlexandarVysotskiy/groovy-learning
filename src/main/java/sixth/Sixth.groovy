package sixth

class Sixth {

    static void deleteFiles(String rootPath) {
        new File(rootPath).eachFileRecurse { it.delete() }
    }
}
