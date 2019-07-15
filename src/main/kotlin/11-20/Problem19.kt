package `11-20`

/*
A builder is looking to build a row of N houses that can be of K different colors.
He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.

Given an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color,
return the minimum cost which achieves this goal.

 */


fun getMinColoringRecursive(matrix:Array<Array<Int>>):Pair<Pair<Int,Int>, Pair<Int,Int>>{
    val noOfHouses = matrix.size
    val noOfColors = matrix[0].size

    val currentHouse = matrix[0]
    val currentColorMinimums = getMinAndSecondMin(currentHouse)
    var minColorIndex = currentColorMinimums.first.first
    var secondMinColorIndex = currentColorMinimums.first.second
    var minVal = currentColorMinimums.second.first
    var secondMinVal = currentColorMinimums.second.second


    if(noOfHouses == 1)
        return Pair(Pair(minColorIndex,secondMinColorIndex), Pair(minVal,secondMinVal))
    else {
        val remainingHouses = matrix.sliceArray(1..matrix.size - 1)
        val remainingHousesPrices = getMinColoringRecursive(remainingHouses)

        val remMinColorIndex = remainingHousesPrices.first.first
        val remSecondMinColorIndex = remainingHousesPrices.first.second
        val remMinVal = remainingHousesPrices.second.first
        val remSecondMinVal = remainingHousesPrices.second.second

        if (minColorIndex == remMinColorIndex) {
            if( remMinVal+secondMinVal < minVal+remSecondMinVal ){
                val tempMin = minVal
                minVal = remMinVal+secondMinVal
                secondMinVal = tempMin+remSecondMinVal

                // Swap
                val tempIndex = minColorIndex
                minColorIndex = secondMinColorIndex
                secondMinColorIndex = tempIndex
            }
            else{
                minVal += remSecondMinVal
                secondMinVal += remMinVal
            }
        }
        else {
            minVal += remMinVal
            if( minColorIndex!=remSecondMinColorIndex && secondMinColorIndex!=remMinColorIndex )
                secondMinVal += remMinVal
            else secondMinVal += remSecondMinVal
        }

        return Pair(Pair(minColorIndex,secondMinColorIndex), Pair(minVal,secondMinVal))
    }
}

fun getMinAndSecondMin(array: Array<Int>):Pair<Pair<Int,Int>, Pair<Int,Int>>
{
    var minVal = Integer.MAX_VALUE
    var secondMinVal = Integer.MAX_VALUE
    var minColorIndex = -1
    var secondMinColorIndex = -1
    if(array.isEmpty())
        return Pair(Pair(minColorIndex,secondMinColorIndex), Pair(minVal, secondMinVal))

    else if(array.size == 1)
        return Pair(Pair(0,secondMinColorIndex), Pair(minVal, secondMinVal))
    else {
        for (i in 0..array.size-1) {
            if(array[i] < secondMinVal) {
                if (array[i] < minVal) {
                    secondMinVal = minVal
                    secondMinColorIndex = minColorIndex

                    minVal = array[i]
                    minColorIndex = i
                }
                else{
                    secondMinVal = array[i]
                    secondMinColorIndex = i
                }
            }
        }

        return Pair(Pair(minColorIndex,secondMinColorIndex), Pair(minVal, secondMinVal))
    }
}

fun getMinColoringOfHomes(matrix:Array<Array<Int>>):Int = getMinColoringRecursive(matrix).second.first