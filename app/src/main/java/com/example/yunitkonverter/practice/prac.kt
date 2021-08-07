package com.example.yunitkonverter.practice

fun main(){
    fun convertLength(lengthBefore:String, lengthAfter:String, value : Double): Double{
        return when(lengthBefore){
            "Kilometre"-> {
                when(lengthAfter){
                    "Kilometre" -> value*1.0
                    "Metre" -> value*1000
                    "Centimeter"-> value * 100000
                    else->0.0
                }
            }
            "Metre"->{
                when(lengthAfter){
                    "Kilometre" -> value/1000
                    "Metre" -> value*1
                    "Centimeter"-> value * 100
                    else->0.0
                }
            }
            else -> when(lengthAfter){
                "Kilometre" -> value/100000
                "Metre" -> value*100
                "Centimeter"-> value * 1
                else->0.0
            }
        }
    }

    println(convertLength("Metre","Centimeter",13.354))
}