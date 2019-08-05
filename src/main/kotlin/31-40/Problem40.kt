package `31-40`

import kotlin.math.pow

/*
Given an array of integers where every integer occurs three times except for one integer,
which only occurs once, find and return the non-duplicated integer.

For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.

Do this in O(N) time and O(1) space.
 */

fun getNonDuplicateNumber(arr:Array<Int>):Int
{
    val wordSize = 10
    var nonDuplicate = 0

    for(i in 0..(wordSize-1)) {
        var sumOfBits = 0
        val checkingNumber:Int = (2.0).pow(i).toInt()

        arr.forEach { num ->
            if(num and checkingNumber != 0)
                sumOfBits ++
        }

        if(sumOfBits % 3 != 0)
            nonDuplicate = nonDuplicate or checkingNumber
    }

    return nonDuplicate
}