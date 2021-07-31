package com.example.yunitkonverter.practice.classes

class Canter( override val type: String) : Vehicle{
    override var speed: Double = 0.0

}

fun main(){
    val canter1 = Canter("Kanter")
    canter1.speed =15.2
    canter1.accelerate(10.2)
    canter1.turn("right")
    println(canter1.describe())


}


