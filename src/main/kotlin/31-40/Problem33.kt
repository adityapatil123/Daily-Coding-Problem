package `31-40`

/*
Compute the running median of a sequence of numbers. That is, given a stream of numbers, print out the median of the list so far on each new element.

Recall that the median of an even-numbered list is the average of the two middle numbers.

For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:

2
1.5
2
3.5
2
2
2
 */

fun getMediansFromStartToEnd(sequenceOfNumbers:Array<Int>):Array<Double>
{
    var sortedNumbers = arrayListOf<Int>()
    val medians = arrayListOf<Double>()

    sequenceOfNumbers.forEachIndexed { i, num ->
        sortedNumbers = insertToSortedArrayList(sortedNumbers, num)
        val sizeOfSortedList = sortedNumbers.size
        if(i%2 == 0)                // Total odd numbers
        {
            val median = sortedNumbers[sizeOfSortedList / 2].toDouble()
            medians.add(median)
        }
        else                        // Total even numbers
        {
            val median = (sortedNumbers[sizeOfSortedList / 2].toDouble() + sortedNumbers[(sizeOfSortedList / 2) - 1].toDouble()) /2
            medians.add(median)
        }
    }

    return medians.toTypedArray()
}

fun insertToSortedArrayList(list:ArrayList<Int>, num:Int):ArrayList<Int>
{
    val newList = arrayListOf<Int>()
    newList.addAll(list)
    val n = newList.size

    if(n == 0)
        return arrayListOf(num)

    var i = n - 1
    newList.add(0)                     //  Add dummy element for provision of added index
    while (i >= 0 && newList[i] > num) {
        newList[i+ 1] =  newList[i]
        i--
    }

    newList[i + 1] = num
    return newList
}