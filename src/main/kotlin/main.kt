fun main() {

    //check is palindrom
    println("isPalindrom(aba) : ${isPalindrom("aba")}")
    println("isPalindrom(adsdas) : ${isPalindrom("adsdas")}")
    println("isPalindrom(data) : ${isPalindrom("data")}")
    println("isPalindrom(katak) : ${isPalindrom("katak")}")
}

fun isPalindrom(input: String) : Boolean{
    return if(input.isBlank()) false else input == input.reversed()
}