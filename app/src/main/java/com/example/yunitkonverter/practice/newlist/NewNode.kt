package com.example.yunitkonverter.practice.newlist

data class NewNode<T>(var value: T, var next : NewNode<T>?=null){
    override fun toString(): String {
        return if(next!=null){
            "$value -> ${next.toString()}"
        }else{
            "$value"
        }
    }
}
