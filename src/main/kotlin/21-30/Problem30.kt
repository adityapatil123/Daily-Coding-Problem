package `21-30`

import kotlin.math.max
import kotlin.math.min

/*
You are given an array of non-negative integers that represents a two-dimensional elevation map where each element is unit-width wall and the integer is the height.
Suppose it will rain and all spots between two walls get filled up.

Compute how many units of water remain trapped on the map in O(N) time and O(1) space.

For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.

Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second,
and 3 in the fourth index (we cannot hold 5 since it would run off to the left), so we can trap 8 units of water.
 */

fun getSpotsFilled(array: Array<Int>):Int
{
    if(array.size < 2)
       error("Provide array with size more than 2")

    var noOfSpotsFilled = 0
    var end1:Int = array[0]
    var end2:Int = array[1]
    var midValues = 0
    var midNumbers = 0
    var middle:Int

   for(i in 2..array.size-1){
       middle = end2
       end2 = array[i]

       if(middle < min(end1, end2)){
           midValues += middle
           midNumbers++
       }
       else if(middle >= max(end1, end2)){
               noOfSpotsFilled += midNumbers*min(end1, middle) - midValues
               midValues = 0
               midNumbers = 0
               end1 = middle
               end2 = array[i]
       }

   }
    noOfSpotsFilled += midNumbers*min(end1, array[array.size-1]) - midValues

    return noOfSpotsFilled
}

/*
Solution:
We will divide it different windows i.e, whenever middle is greater than both ends, slide the window.
Initialise midValues and midNumbers for the calculation of noOfSpots for each window.
Update the values only when middle is lesser than both ends.
Whenever window is slided, calculate spots for that window, and re-initialise midValues and midNumbers.
Find the spots at the end,  because sliding condition will not be there
Return final spots.
 */