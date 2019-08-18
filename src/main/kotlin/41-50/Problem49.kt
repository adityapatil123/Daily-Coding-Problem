package `41-50`

import kotlin.math.max

/*
Given an array of numbers, find the maximum sum of any contiguous subarray of the array.

For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137,
since we would take elements 42, 14, -5, and 86.

Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.

Do this in O(N) time.
 */

fun getMaxSumRecursive(arr:Array<Int>):Pair<Int, Int>
{
    if((arr.size == 1 && arr[0] < 0) || (arr.isEmpty()))
        return Pair(0,0)
    else if(arr.size == 1 && arr[0] >= 0)
        return Pair(arr[0], arr[0])

    val pair = getMaxSumRecursive(arr.sliceArray(1..arr.size - 1))
    var sum1 = pair.first
    var sum2 = pair.second

    sum2 = max(sum1, sum2)
    sum1 += arr[0]

    return Pair(sum1, sum2)
}

fun getMaxSumContiguousSubarray(arr: Array<Int>):Int
{
    val sumPair = getMaxSumRecursive(arr)
    return max(sumPair.first, sumPair.second)
}

fun main()
{
    println(getMaxSumContiguousSubarray(arrayOf(34, -50, 42, 14, -5, 86)))
}