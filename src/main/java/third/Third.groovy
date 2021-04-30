package third

/**
 * 3.1. В заданной папке найти все файлы с расширением TXT, содержащие в названии только цифры:
 * для каждого такого файла поменять название на
 * [обратный порядок цифр][сумма цифр].dat
 * Пример:
 *
 * 12356.txt -> 6532117.dat
 */

class Third {

    File[] find(String path) {
        new File(path).eachFileMatch(~/.*\.txt/) {file ->
            file.renameTo(file.path.replace( file.name, getNewName(file)))
        }

        new File(path).listFiles()
    }

    private String getNewName(File file) {
        String onlyNumber = file.name.find(~/\d*/)

       """${onlyNumber.reverse()}${onlyNumber.collect{it as int}.value.sum() }.dat"""
    }
}
