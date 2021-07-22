package com.example.yunitkonverter.practice.classes

fun main(){
    val grace = Student(name = "Grace", gender = "Female",id=2345)
    val lucy = grace.copy(id = 85)
    lucy.name = "Lucy"

    val (x,y,z) = grace
    val tshirt1 = Tshirt(price = 60.5)
    val tshirt2 = Tshirt(price = 70.0)
    val destination = Address("Eldoret")
    val cartOne = ShoppingCart(tShirts = listOf(tshirt1,tshirt2),destination)
    val mirian = User(name = "Mirian",email = "miri@gmail.brazil",cartOne)
    var mirianCartPrice = mirian.cart.getTotalCost()

    println(mirianCartPrice)

}

