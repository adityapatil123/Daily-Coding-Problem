package `41-50`/*
Given a list of integers S and a target number k, write a function that returns a subset of S that adds up to k.
If such a subset cannot be made, then return null.

Integers can appear more than once in the list. You may assume all numbers in the list are positive.

For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up to 24.
*/

fun getSubsetWithSumK(array: Array<Int>, k:Int):Array<Int>?
{
    if(array.isEmpty())
        return null
    else{
        val desiredSubset = getSubsetRecursive(array, k).second
        if(desiredSubset == null)
            return null
        else
            return desiredSubset.toTypedArray()
    }
}

fun getSubsetRecursive(array: Array<Int>, k:Int):Pair<ArrayList<ArrayList<Int>>, ArrayList<Int>?>
{
    var desiredSubset:ArrayList<Int>? = null
    val subsets = arrayListOf<ArrayList<Int>>()
    val first = array[0]
    if(first == k)
        desiredSubset = arrayListOf(first)
    subsets.add(arrayListOf(first))

    if(array.size == 1)
        return Pair(subsets, desiredSubset)

    val remainingArray = array.sliceArray(1..array.size-1)
    val remaining = getSubsetRecursive(remainingArray, k)

    if(remaining.second == null) {
        val nextSubsets = remaining.first

        val additionOfFirstAndNextSubsets = arrayListOf<ArrayList<Int>>()
        nextSubsets.forEach { subset ->
            val newSubset = arrayListOf(first)
            newSubset.addAll(subset)
            additionOfFirstAndNextSubsets.add(newSubset)
        }

        subsets.addAll(nextSubsets)
        subsets.addAll(additionOfFirstAndNextSubsets)

        desiredSubset = getDesiredSubset(subsets, k)
    }
    else
        desiredSubset = remaining.second

    return Pair(subsets, desiredSubset)
}


fun getSumOfSubset(subset:ArrayList<Int>):Int
{
    var sum = 0
    subset.forEach { elem ->
        sum += elem
    }
    return sum
}

fun getDesiredSubset(subsets:ArrayList<ArrayList<Int>>, k: Int):ArrayList<Int>?
{
    subsets.forEach { subset ->
        if(getSumOfSubset(subset) == k)
            return subset
    }
    return null
}