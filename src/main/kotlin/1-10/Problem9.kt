import java.util.Collections.max
import kotlin.math.max

//Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.
//
//For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
//
//Follow-up: Can you do this in O(N) time and constant space?

fun largestSumNonAdjacent(arr:Array<Int>):Int?{
    if(arr.isEmpty())
        return null

    val pair = getSumForFirstSecond(arr)
    if(arr.size == 1)
        return pair.first
    else
        return max(pair.first, pair.second)
}

fun getSumForFirstSecond(arr:Array<Int>):Pair<Int,Int>
{
    val arraySize = arr.size
    var sum1 =  0
    var sum2 =  0
    if(arraySize == 1){
        sum1 = arr[0]
    }
    else{
        val tailArray = arr.sliceArray(1..arraySize-1)
        sum1 = getSumForFirstSecond(tailArray).first
        sum2 = getSumForFirstSecond(tailArray).second

        val tempSum1 = sum1
        sum1 = arr[0] + sum2
        sum2 = max(tempSum1, sum2)
    }


    return Pair(sum1,sum2)
}