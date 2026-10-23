package main.kotlin.task03

enum class Delivery { PICKUP, COURIER, EXPRESS , DRONE }

fun shippingCost(type: Delivery, weightKg: Double): Double = when (type) {
    Delivery.PICKUP -> 0.0
    Delivery.COURIER -> 15_000 + 2_000 * weightKg
    Delivery.EXPRESS -> 40_000 + 5_000 * weightKg
    Delivery.DRONE -> 25_000 + 3000 * weightKg
    //else -> 0.0
}

fun main() {
    println("Delivery types: ${Delivery.entries.joinToString()}")
    print("Delivery type: ")
    val typeName = readln().trim()
    val type = Delivery.entries.firstOrNull { it.name.equals(typeName, ignoreCase = true) }
    if (type == null) {
        println("Unknown delivery type")
        return
    }
    print("Weight in kg: ")
    val weight = readln().trim().toDoubleOrNull()
    if (weight == null || weight < 0) {
        println("Invalid weight")
        return
    }
    println("Shipping cost: ${"%.0f".format(shippingCost(type, weight))} UZS")
}


// task 1 - done

//task 2 - 'when' expression must be exhaustive. Add the 'DRONE' branch or an 'else' branch. , becouse logic isnot inside the main inside function

// task 3 - done

// task 4 - shows customer should pay 0 UZS , no error occured

// task 5 - done

