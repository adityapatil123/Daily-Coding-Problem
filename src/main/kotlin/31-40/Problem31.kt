package `31-40`

import kotlin.math.absoluteValue
import kotlin.math.min

/*
The edit distance between two strings refers to the minimum number of character insertions, deletions, and substitutions required to change one string to the other.
For example, the edit distance between “kitten” and “sitting” is three: substitute the “k” for “s”, substitute the “e” for “i”, and append a “g”.

Given two strings, compute the edit distance between them.
 */

fun getEditDistance(str1:String, str2:String):Int
{
    val str1Length = str1.length
    val str2Length = str2.length
    val diffBetweenLengths = (str1Length - str2Length).absoluteValue
    var editDistance = diffBetweenLengths

    for( i in 0..min(str1Length, str2Length)-1){
        if(str1[i] != str2[i])
            editDistance++
    }

    return editDistance
}