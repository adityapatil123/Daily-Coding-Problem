//Given an array of integers, find the first missing positive integer in linear time and constant space.
// In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
//
//For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
//
//You can modify the input array in-place.



// Using Hash-set and its contains function
fun getMinPosAbsent(array: Array<Int>):Int
{
    val set = array.toHashSet()

    for(i in 1..array.size){
        if(set.contains(i) == false)
            return i
    }

    return array.size + 1
}



// Using Array and in-place modifying
// Consider range from 1 to array-length, Hence element and index will be same for that range and ignore other numbers such as non-negative, greater than array-length and duplicate

fun getMinPosAbsent2(array: Array<Int>):Int
{
    for(i in 0..array.size-1){
        if(array[i]>0 && array[i]<=array.size && array[i]!=i+1){     // Check if any number is not at right pos only and is in the range
            while(true){
                val k = array[i] -1

                if(array[k] == array[i])     // Break if Duplicate
                    break

                val temp = array[k]         // Swap number at i and number with value at i as index
                array[k] = array[i]
                array[i] = temp

                if(array[i]<0 || array[i]>array.size || array[i] == i+1)      // Break if array is not in range or elem = index
                    break
            }
        }
    }

    for(i in 0..array.size-1){
        if(array[i]!= i+1)           // Return if range is not filled in between the range
            return i+1
    }

    return array.size+1         // If every element is present between range then return range-size + 1
}