package com.example.yunitkonverter.practice.classes

enum class Direction {
    LEFT , RIGHT
}

interface Vehicle {
    var speed : Double
    val type : String
    fun accelerate(velocity : Double){
        speed += velocity
    }

    fun stop(){
        speed = 0.0
    }

    fun turn(direction: String){
        if (speed == 0.0){
            return
        }else if (direction.toLowerCase() == "right"){
            Direction.RIGHT
        }else if(direction.toLowerCase() == "left"){
            Direction.LEFT
        }else return
    }

    fun describe(): String{
        return when(speed){
            0.0 -> "$type is stationary at the moment"
            else -> "Your $type is moving at $speed km/hr and is turning"
        }
    }

}