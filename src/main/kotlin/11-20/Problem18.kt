package `11-20`

import kotlin.math.max

/*
Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.

For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:

10 = max(10, 5, 2)
7 = max(5, 2, 7)
8 = max(2, 7, 8)
8 = max(7, 8, 7)
Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. You can simply print them out as you compute them.
*/

fun printMaxValuesOfSubarrays(array: Array<Int>, k:Int)
{
    val arraLength = array.size
    if(k > arraLength)
    {
        print("K can't be greater than arrayLength")
        return
    }

    val maxValArray = arrayListOf<Int>()
    for(i in 0..k-1)
        maxValArray.add(0)

    for(i in (k-1).downTo(0)){
        if(i == k-1)
            maxValArray[i] = array[i]
        else
            maxValArray[i] = max(array[i], maxValArray[i+1])
    }

    println(maxValArray[0])                                        // Print Max Element of first sub array
    maxValArray.removeAt(0)


    // For Remaining
    for(i in k..arraLength-1){
        maxValArray.add(array[i])
        println(max(maxValArray[0],array[i]))                       // Print Max Element of sub array

        var j = i-1
        var p = k-2
        while(array[i] > array[j] && j>=0 && p>=0)
        {
            maxValArray[p] = array[i]
            j--
            p--
        }
    }
}