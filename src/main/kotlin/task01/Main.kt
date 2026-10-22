package main.kotlin.task01

enum class OrderStatus { NEW, PAID, SHIPPED, DELIVERED, CANCELLED }

fun main() {
    println("Statuses: ${OrderStatus.entries.joinToString()}")
    print("Current status of your order: ")
    val text = readln().trim().uppercase()

    //     FIRST VERSION

//    val status = try{
//        OrderStatus.valueOf(text)}
//    catch (e: IllegalArgumentException){
//        println("'$text' is not a status. Valid: ${OrderStatus.entries.map { it.name }}")
//        return
//    }

    //     SECOND VERSION

    val status = OrderStatus.entries.firstOrNull {it.name == text }

    if (status == null) {
        println("'$text' is not a status. Valid: ${OrderStatus.entries.map { it.name }}")
        return
    }

    println("You entered ${status.name}: step ${status.ordinal + 1} of ${OrderStatus.entries.size}")
    val next = OrderStatus.entries.getOrNull(status.ordinal + 1)
    println(if (next == null) "This is the last step." else "Next step: $next")
    println(OrderStatus.PAID === OrderStatus.valueOf("PAID"))
}

// task 1 - program calls uppercase becouse if user types forexample paid in lowercase it will make it uppercase
// in orer to make it same as enum classes values that it includes

// task 2 - IllegalArgumentException occurs

// task 3 - done , second one becouse code is organised well

// task 4 - it prints this, and i just changed first line
//Statuses: NEW, PAID, SHIPPED, DELIVERED, CANCELLED
//Current status of your order: delivered
//You entered DELIVERED: step 4 of 5
//Next step: CANCELLED

// task 5 - it says true , it says about Referential Equality of both objects in memory
