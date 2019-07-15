package `11-20`

import java.util.stream.Stream

// Given a stream of elements too large to store in memory,
// pick a random element from the stream with uniform probability.

fun getRandomElem(stream:Stream<Int>):Int?
{
    var i:Long = 0
    var random:Double = 0.0
    var randomElem:Int? = null

    stream.forEach { elem ->
        val newRandom = Math.random()
        if(newRandom > random) {
            random = newRandom
            randomElem = elem
        }
    }
    return randomElem
}

fun main(){
    val list = arrayListOf<Int>(1,2,3,7)
    val streamOfInt = list.stream()
    println(getRandomElem(streamOfInt))
}