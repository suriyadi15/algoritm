import java.util.*
import kotlin.collections.ArrayList

fun main() {

    //check is palindrom
    println("check palindrom:")
    println("isPalindrom(aba) : ${isPalindrom("aba")}")
    println("isPalindrom(adsdas) : ${isPalindrom("adsdas")}")
    println("isPalindrom(data) : ${isPalindrom("data")}")
    println("isPalindrom(katak) : ${isPalindrom("katak")}")

    //fibonacci
    println()
    println("print fibonacci:")
    println("fib(1): ${fibonacci(1)}")
    println("fib(3): ${fibonacci(3)}")
    println("fib(5): ${fibonacci(5)}")
    println("fib(10): ${fibonacci(10)}")
    println("fib(20): ${fibonacci(20)}")
    println("fib(100): ${fibonacci(100)}")

    println()
    println("print prime number")
    println("prime(10) = ${primeNumber(10)}")
    println("prime(100) = ${primeNumber(100)}")

    println()
    println("print oddCount")
    println("oddCount(7) = ${oddCount(7)}")
    println("oddCount(15) = ${oddCount(15)}")

    println()
    println("print romanToNumber")
    println("romanToNumber(XXI) = ${romanToNumber("XXI")}")
    println("romanToNumber(IX) = ${romanToNumber("IX")}")

    println()
    println("print numberToRoman")
    println("numberToRoman(21) = ${numberToRoman(21)}")
    println("numberToRoman(9) = ${numberToRoman(9)}")

    println()
    println("print insertionSort")
    println("insertionSort(4,3,2,10,12,1,5,6) = ${insertionSort(arrayListOf(4, 3, 2, 10, 12, 1, 5, 6))}")

    println()
    println("print bubbleSort")
    println("bubbleSort(4,3,2,10,12,1,5,6) = ${bubbleSort(4, 3, 2, 10, 12, 1, 5, 6)}")
}

fun isPalindrom(input: String): Boolean {
    return if (input.isBlank()) false else input == input.reversed()
}

val fiboMaps = hashMapOf<Long, Long>()
fun fibonacci(n: Long): Long {
    if (fiboMaps.containsKey(n)) return fiboMaps[n]!!

    val result = if (n <= 1) n else (fibonacci(n - 1) + fibonacci(n - 2))
    fiboMaps[n] = result
    return result
}

fun primeNumber(n: Long): List<Long> {
    val primeList = mutableListOf<Long>()

    var index = 2L
    while (true) {
        if (primeList.size.toLong() == n) break

        if (isPrime(index)) {
            primeList.add(index)
        }
        index++
    }
    return primeList
}

fun isPrime(n: Long): Boolean {
    var isPrime = true
    for (i in 2 until n) {
        if (n % i == 0L) {
            isPrime = false
        }
    }
    return isPrime
}

/*
Given a number n, return the number of positive odd numbers below n
oddCount(7) //=> 3, i.e [1, 3, 5]
oddCount(15) //=> 7, i.e [1, 3, 5, 7, 9, 11, 13]
 */
fun oddCount(n: Long): Long {
    return if ((n - 1) % 2 == 0L) {
        (n - 1) / 2
    } else {
        ((n - 1) / 2) + 1
    }
}

fun romanToNumber(roman: String): Int {
    val maps = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )

    var result = 0
    var i = 0
    while (i < roman.length) {
        val s1 = maps[roman[i]] ?: error("input not valid")

        if (i + 1 < roman.length) {
            val s2 = maps[roman[i + 1]] ?: error("input not valid")

            if (s1 >= s2) {
                result += s1
            } else {
                result += s2 - s1
                i++
            }
        } else {
            result += s1
        }
        i++
    }

    return result
}

val romanMaps = TreeMap<Int, String>().apply {
    put(1000, "M")
    put(900, "CM")
    put(500, "D")
    put(400, "CD")
    put(100, "C")
    put(90, "XC")
    put(50, "L")
    put(40, "XL")
    put(10, "X")
    put(9, "IX")
    put(5, "V")
    put(4, "IV")
    put(1, "I")
}

fun numberToRoman(number: Int): String {
    val l = romanMaps.floorKey(number)
    if (l == number) return romanMaps[l] ?: error("input not valid")
    return "${romanMaps[l]}${numberToRoman(number - l)}"
}

fun <T> insertionSort(arr: ArrayList<T>): ArrayList<T> where T : Number {
    val result = arr.clone() as ArrayList<T>
    for (i in 1 until result.size) {
        val key = result[i]

        var j = i - 1

        while (j >= 0 && result[j].toDouble() > key.toDouble()) {
            result[j + 1] = result[j]
            j--
        }
        result[j + 1] = key
    }
    return result
}

fun <T> bubbleSort(vararg numbers: T): List<T> where T : Number {
    val result = numbers.asList().toMutableList()

    for (i in result.indices) {
        for (j in 0 until result.size - i - 1) {
            if (result[j].toDouble() > result[j + 1].toDouble()) {
                val temp = result[j]
                result[j] = result[j + 1]
                result[j + 1] = temp
            }
        }
    }
    return result
}