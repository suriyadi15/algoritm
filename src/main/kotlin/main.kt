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
    return if((n-1) % 2 == 0L){
        (n-1) / 2
    }else{
        ((n-1) / 2) + 1
    }
}