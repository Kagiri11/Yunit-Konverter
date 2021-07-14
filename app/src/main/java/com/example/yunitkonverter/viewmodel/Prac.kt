package com.example.yunitkonverter.viewmodel

fun main(){
    val length = listOf<String>(
        "Kilometre",
        "Miles",
        "Metre",
        "Centimetre",
        "Millimetre",
        "Micrometre",
    )


    println(convertLength(50.2,"Metre","else"))

}

fun convertLength(value:Double,fromWhat:String,toWhat:String):Double{
    return when(fromWhat){
        "Kilometre"->  {
            when(toWhat){
                "Metre" -> value*1000
                "Kilometre"-> value
                else -> value*100000
            }
        }
        "Metre"->  {
            when(toWhat){
                "Kilometre" -> value/1000
                "Metre"-> value
                else -> value*100
            }
        }
        else->{
            when(toWhat){
                "Kilometre" -> value/100000
                "Metre"-> value/100
                else -> value
            }
        }
  }

}