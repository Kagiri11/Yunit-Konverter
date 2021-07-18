package com.example.yunitkonverter.practice.newlist

fun main(){
    val listOne = Linkedlist<String>()
    listOne.push("Charles").push("Eunice").push("Joseph")
    listOne.append("Ian").append("Peter")
    println(listOne)
}