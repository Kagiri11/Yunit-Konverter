package com.example.yunitkonverter.practice.classes

data class ShoppingCart(
    val tShirts: List<Tshirt>,
    val destination : Address,
){
    fun getTotalCost():Double{
        var totalPrice : Double = 0.0
        for (items in tShirts){
            totalPrice += items.price
        }
        return totalPrice
    }

    fun shipTo(): String{
       return  "This parcel goes to ${destination.home}"
    }
}
