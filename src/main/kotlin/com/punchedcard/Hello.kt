package com.punchedcard

import io.javalin.Javalin

fun main(args: Array<String>) {
    val (type, price, size) = Coffee(type = "Latte", price = 3.5, size = "large")

    val coffeeOptions = hashMapOf(
        0 to Coffee(type = "Latte", price = 3.5, size = "large"),
        1 to Coffee(type = "Mocha", price = 4.0, size = "large"),
        2 to Coffee(type = "Flat White", price = 3.5, size = "large"),
        3 to Coffee(type = "Cappuccino", price = 3.5, size = "large")
    )

    val menu = coffeeOptions.values.map { (type, price, size) ->
        "$type is $price for $size"
    }.joinToString("\n")

    val app = Javalin.create().start(7000)
    app.get("/") { ctx ->
        ctx.result("Hello,\n$menu")
    }
}

