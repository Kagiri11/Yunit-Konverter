package com.example.yunitkonverter.practice.newlist

fun main(){
    val mySentence= "No matter how I fail I will always get back up and try to do my best"
    print(getLongestWord(mySentence))
}

fun getLongestWord(sentence: String):String{
    val sentenceArray = sentence.split(" ")
    val sortedSentence =sentenceArray.sortedBy { it.length }
    var answer = sortedSentence.last()
    for(word in sortedSentence){
        val lastWord=sortedSentence[sortedSentence.size-1]
        val secondLastWord= sortedSentence[sortedSentence.size-2]
        if (lastWord.length==secondLastWord.length){
            answer = secondLastWord
        }

    }

    return answer
}