package first

class FirstOneDotTwo {

//    найти количество различных чисел;
    int findDifferenceNumberAmount(int[] source) {
       source.toList().unique().size()
    }

//    найти максимальное и минимальное число;
    int[] findMaxAndMinNumber(int[] source) {
        if (source.collect().isEmpty()) {
            return []
        }

        [source.toList().min(), source.toList().max()];
    }

//    увеличить каждое число в 2 раза если оно положительное и в три раза если оно отрицательное;
    int[] increase(def source) {
        source.inject([]) {res, it ->
            if (it < 0) {
                res << it * 3
            } else if (it > 0) {
                res << it * 2
            } else {
                res << it
            }

            res
        }
    }

//    имеется второй массив неупорядоченных чисел: определить числа, входящие и в первый и во второй массив;
    int[] containsNumbers(def first, def second) {
         first.toList().intersect(second.toList())
    }
}
