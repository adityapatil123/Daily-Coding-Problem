package `41-50`/*
We can determine how "out of order" an array A is by counting the number of inversions it has.
Two elements A[i] and A[j] form an inversion if A[i] > A[j] but i < j.
That is, a smaller element appears after a larger element.

Given an array, count the number of inversions it has. Do this faster than O(N^2) time.

You may assume each element in the array is distinct.

For example, a sorted list has zero inversions.
The array [2, 4, 1, 3, 5] has three inversions: (2, 1), (4, 1), and (4, 3).
The array [5, 4, 3, 2, 1] has ten inversions: every distinct pair forms an inversion.
 */

fun getOutOfOrderNumber(arr:Array<Int>):Int = mergeSort(arr).second

fun mergeSort(arr:Array<Int>):Pair<Array<Int>, Int>
{
    if(arr.isEmpty() || arr.size == 1)
        return Pair(arr, 0)

    val mid = arr.size/ 2
    println("Mid " + mid)
    arr.sliceArray(0..(mid-1)).forEach { print(it.toString() + "\t") }
    println()
    arr.sliceArray(mid..(arr.size-1)).forEach { print(it.toString() + "\t") }
    println()

    val pair = merge(
        mergeSort(arr.sliceArray(0..(mid - 1))), mergeSort(arr.sliceArray(mid..(arr.size - 1)))
    )

    return pair
}

fun merge(pairBeforeMid:Pair<Array<Int>, Int>, pairAfterMid:Pair<Array<Int>, Int>):Pair<Array<Int>, Int>
{
    var i = 0
    var k = 0

    val merged:ArrayList<Int> = arrayListOf()
    val a = pairBeforeMid.first
    val aInv = pairBeforeMid.second
    val b = pairAfterMid.first
    val bInv = pairAfterMid.second
    var inversions = aInv + bInv

    while(i < a.size && k < b.size) {
        if(a[i] < b[k]){
            merged.add(a[i])
            i += 1
        }
        else {
            merged.add(b[k])
            inversions += a.size - i
            k += 1
        }
    }

    while(i < a.size) {
        merged.add(a[i])
        i += 1
    }
    while(k < b.size) {
        merged.add(b[k])
        k += 1
    }

    return Pair(merged.toTypedArray(), inversions)

}