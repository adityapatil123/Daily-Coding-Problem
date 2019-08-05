package `31-40`/*
Given an array of strictly the characters 'R', 'G', and 'B',
segregate the values of the array so that all the Rs come first, the Gs come second, and the Bs come last.
You can only swap elements of the array.

Do this in linear time and in-place.

For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'],
it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].
 */

fun segregateRGB(array: Array<Char>):Array<Char>
{
    val lastIndex = array.size - 1
    var sortedTillBeforeIndex = 0
    sortedTillBeforeIndex = segregateForChar(array, sortedTillBeforeIndex, lastIndex, 'R')
    segregateForChar(array, sortedTillBeforeIndex, lastIndex, 'G')
    return array
}

fun swapIndices(arr:Array<Char>, index1:Int, index2:Int)
{
    val temp = arr[index1]
    arr[index1] = arr[index2]
    arr[index2] = temp
}

fun segregateForChar(arr:Array<Char>, startIndex:Int, endIndex:Int, letter:Char):Int {
    var i = startIndex
    var j = endIndex

    while (i < j) {
        if (arr[i] == letter)
            i++
        else if (arr[j] == letter) {
            swapIndices(arr, i, j)
            i++
        } else
            j--
    }
    return i
}