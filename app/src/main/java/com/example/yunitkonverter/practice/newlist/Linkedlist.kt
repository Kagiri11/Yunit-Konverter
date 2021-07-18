package com.example.yunitkonverter.practice.newlist

class Linkedlist<T> {
    var head: NewNode<T>? = null
    var tail: NewNode<T>? = null
    var size = 0

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun push(value: T): Linkedlist<T> {
        head = NewNode(value = value, next = head)
        if (isEmpty()) {
            tail = head
        }
        size++
        return this
    }


    //Append adds a new node to the end of the list
    fun append(value:T):Linkedlist <T>{
        if (isEmpty()){
            push(value)
        }
        tail?.next = NewNode(value=value)
        tail=tail?.next
        size++
        return this
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty List"
        } else {
            head.toString()
        }
    }
}