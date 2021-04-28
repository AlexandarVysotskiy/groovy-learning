package first

class FirstOneDotOne {

//    найти все слова, содержащие только буквы нижнего регистра;
    String findLettersWithUpperCase(String source) {
        def result = ''

        source.each { l ->
            if (l.toLowerCase().equals(l)) {
                result += l
            }
        }

        result
    }


//    вывести символы с 11-го по 16-ый (с учетом, что строка больше 16 символов);
    String findLettersFromOneIndexToSecond(String source, int firstIndex, int secondIndex) {
        String result = ''

        if (source.length() >= secondIndex) {
            result = source[firstIndex..secondIndex]
        }

        result
    }


//    вывести все буквы английского алфавита (нижний регистр);
    String findEnglishLettersFromString(String source) {
      def result = ''

        source.each { l ->
            if (l >= 'a' && l <= 'z') {
                result += l
            }
        }

        result
    }


//    поменять во всех словах строки первую букву на заглавную;
    String makeFirstLitterToUpperCase(String source) {
        def result

        result = source[0].toUpperCase()

        for (int i = 1; i < source.length(); i++) {
            if (source[i - 1] == ' ') {
                result += (source[i].toUpperCase())
            } else {
                result += (source[i])
            }
        }

        result
    }

//    найти все слова, реверсия которых (обратный порядок букв) идентична самому слову
//    и количество различных букв (исключая повторения) в слове меньше 5.
//    (пример: 'bob', 'reviver', 'rotator')
    String findPalinromes(String source) {
        def result = ""
        def temp = ''

        for (int i = 0; i < source.length(); i++) {
            if (source[i].matches("\\S")) {
                temp += source[i]
            }

           if (source[i].matches("\\s") || i + 1 == source.length()) {
               if (temp.length() < 5 && isPalinromes(temp)) {
                   result += temp + ' '
               }
               temp = ''
           }
        }

        result
    }

    boolean isPalinromes(String source) {
        boolean result

        String reverseString = ""

        int length = source.length()

        for(int i = length - 1; i >= 0; i --) {
            reverseString = reverseString + source.charAt(i)

            if (source.equalsIgnoreCase(reverseString)) {
                result = true
            }
        }

        result
    }


//    определить, содержит ли строка электронный адрес;
    boolean isEmail(String source) {
       source.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")
    }
}
