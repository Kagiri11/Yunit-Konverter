package com.example.yunitkonverter.viewmodel

class ConverterViewModel {

    val length = listOf<String>(
        "Kilometre",
        "Miles",
        "Metre",
        "Centimetre",
        "Millimetre",
        "Micrometre",
        "Nanometer",
        "Yard",
        "Feet",
        "Inch",
        "Nautical Mile",
        "Furlong",
        "Light Year"
    )
    fun convertLength(value:Double,selectedValue :String):Double{
        return when(value){
            4.5 -> value*0.9
            else -> value*0.4
        }

    }
}