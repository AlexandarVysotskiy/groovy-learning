//package first
//
//class FirstOneDotOne {
//
////    найти все слова, содержащие только буквы нижнего регистра;
//    String[] findWordsOnlyWithLettersInLowerCase(String source) {
//        source.split().findAll { it -> it.toLowerCase() == it }
//    }
//
////    вывести символы с 11-го по 16-ый (с учетом, что строка больше 16 символов);
//    String findLettersFromOneIndexToSecond(String source, int firstIndex, int secondIndex) {
//        String result = ''
//
//        if (source.length() >= secondIndex) {
//            result = source[firstIndex..secondIndex]
//        }
//
//        result
//    }
//
////    вывести все буквы английского алфавита (нижний регистр);
//    String findEnglishLettersFromString(String source) {
//        def result = ''
//
//        source.eachMatch("[a-z]", { it ->
//            result += it
//        })
//
//        result
//    }
//
////    поменять во всех словах строки первую букву на заглавную;
//    String[] makeFirstLitterToUpperCase(String source) {
//        source.split().collect{ it -> it.capitalize()}
//    }
//
////    найти все слова, реверсия которых (обратный порядок букв) идентична самому слову
////    и количество различных букв (исключая повторения) в слове меньше 5.
////    (пример: 'bob', 'reviver', 'rotator')
//    String[] findPalinromes(String source) {
//        source.split().inject([]){res, it ->
//            if (it.length() < 5 && it == it.reverse()) {
//                res << it
//            }
//
//            res
//        }
//    }
//
////    определить, содержит ли строка электронный адрес;
//    boolean isEmail(String source) {
//        source.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")
//    }
//}
