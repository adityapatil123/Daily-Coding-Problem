//The question we'll work through is the following: return a new sorted merged list from K sorted lists, each with size N.
// Before we move on any further, you should take some time to think about the solution!
//
//First, go through an example.
// This buys time, makes sure you understand the problem, and lets you gain some intuition for the problem.
// For example, if we had [[10, 15, 30], [12, 15, 20], [17, 20, 32]], the result should be [10, 12, 15, 15, 17, 20, 20, 30, 32].
var smallest:Int = Int.MAX_VALUE

fun sortAndMerge(listOfList: Array<Array<Int>>):Array<Int?>
{
    var noOfElem = 0
    listOfList.forEach { internalArray ->
        noOfElem += internalArray.size
    }


    val mergeList= arrayOfNulls<Int>(noOfElem)

    val noOfLists = listOfList.size
    val ptr = arrayOfNulls<Int>(noOfLists)
    ptr.fill(0,0,noOfLists)
    var arr = arrayOfNulls<Int>(noOfLists)


    for(j in 0..noOfElem-1) {
        for (i in 0..noOfLists - 1) {
            try {
                arr.set(i,(listOfList[i][ptr[i]!!]))
            } catch (e: Exception) {
                arr.set(i,Int.MAX_VALUE)
//                println("Exception")
            }
        }

        if(arr.size != 1) {
            for (i in arr.size / 2 - 1 downTo 0)
                arr = heapify(arr, arr.size, i)


            ptr[smallest] = ptr[smallest]!!.plus(1)
        }

        val min = arr[0]
        mergeList.set(j,min)


    }
    return mergeList
}

fun heapify(arr: Array<Int?>, n:Int, i:Int):Array<Int?>{
    if(arr.isNullOrEmpty())
        return arrayOfNulls(n)

    smallest = i
    val l = 2 * i + 1
    val r = 2 * i + 2
    var newArray = arr
    // if left child is larger than root
    if (l < n && arr[l]!! < arr[smallest]!!)
        smallest = l

    // if right child is larger than largest so far
    if (r < n && arr[r]!! < arr[smallest]!!)
        smallest = r

    // if largest is not root
    if (smallest != i) {
        val temp = arr[i]
        arr[i] = arr[smallest]
        arr[smallest] = temp
//        swap(arr[i], arr[largest])

        // recursively `1-10`.heapify the affected sub-tree
        newArray = heapify(arr, n, smallest)
    }
    return newArray
}