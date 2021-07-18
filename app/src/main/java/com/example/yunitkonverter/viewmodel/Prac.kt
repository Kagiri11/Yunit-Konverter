package com.example.yunitkonverter.viewmodel

import com.example.yunitkonverter.practice.LinkedList
import com.example.yunitkonverter.practice.Node

fun main() {
    val node1 = Node(value = 1)
    val node2 = Node(value = 2)
    val node3 = Node(value = 3)

    node1.next = node2
    node2.next = node3
    println(node1)

    val list = LinkedList<Int>()
    list.push(3).push(12).push(8).append(10)
    println(list)
    val secondNode = list.nodeAt(1)!!
    list.insert(13,secondNode)
    println(list)

    var newList = LinkedList<Int>()
    println(newList)
    newList.push(10).push(20)
    val specificNode = newList.nodeAt(0)
    newList.insert(30,specificNode!!)
    println(newList)
    newList.pop()
    println(newList)
    newList.removeLast()
    println(newList)
}

fun isDivisible(value: Int, divisor: Int) {
    if (value % divisor == 0) {
        val numberOfTimesDivisible = value / divisor
        println("Yep it is divisible by $divisor $numberOfTimesDivisible times")
    } else {
        println("No it is not divisible :(")
    }
}

fun getNameLength(name: String?): Int {
    return name?.length ?: 0
}