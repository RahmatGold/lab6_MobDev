package main.kotlin.task02

import kotlin.math.pow

enum class Operation(val symbol: String) {
    ADD("+") {
        override fun apply(a: Double, b: Double) = a + b
    },
    SUBTRACT("-") {
        override fun apply(a: Double, b: Double) = a - b
    },
    MULTIPLY("*") {
        override fun apply(a: Double, b: Double) = a * b
    },
    DIVIDE("/") {
        override fun apply(a: Double, b: Double) = a / b
    },
    MODULO("%"){
        override fun apply(a:Double,b: Double) = a % b
    },
    POWER("^"){
        override fun apply(a: Double,b: Double) = a.pow(b)
    };

    abstract fun apply(a: Double, b: Double): Double

    companion object {
        fun fromSymbol(symbol: String): Operation? =
            entries.firstOrNull { it.symbol == symbol }
    }
}

fun main() {
    print("Expression (for example 12 * 4): ")
    val parts = readln().trim().split(" ")
    if (parts.size != 3) {
        println("Use: number operator number")
        return
    }
    val a = parts[0].toDoubleOrNull()
    val b = parts[2].toDoubleOrNull()
    val operation = Operation.fromSymbol(parts[1])
    if (a == null || b == null || operation == null) {
        println("Cannot understand '${parts.joinToString(" ")}'")
        return
    }
    if (operation == Operation.DIVIDE && b == 0.0) {
        println("Division by zero")
        return
    }
    println("$a ${operation.symbol} $b = ${operation.apply(a, b)}")

}

// task 1 - 39th line rejects if 5 / 0 operation is applied and 28th line works if i enter  abc

// task 2 - symbol + is stored here -> ADD("+")

// task 3 - Enum entry 'Operation.MODULO' does not implement abstract member:
//fun apply(a: Double, b: Double): Double

// task 4 - it is like static function of class not an object

// task 5 - done