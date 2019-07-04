//Given an array of integers, return a new array
// such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
//
//For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
// If our input was [3, 2, 1], the expected output would be [2, 3, 6].
//Follow-up: what if you can't use division?

// Time Complexity : O(n2)
fun productOther(arr: Array<Int>):Array<Int?>
{
    val newArr = arrayOfNulls<Int>(arr.size)
    for(i in 0..arr.size-1){
        var j = 0
        var prod:Int = 1
        while(j<arr.size){
            if(j!=i)
                prod *= arr[j]
            j++
        }
        newArr.set(i,prod)
    }
    return newArr
}

// Time Complexity : O(n)
fun productOther2(arr:Array<Int>):Array<Int?>
{
    var product = 1
    val productRightArray :Array<Int?> = arrayOfNulls<Int>(arr.size)
    for (i in 0..arr.size-1){
        product *= arr[i]
        productRightArray.set(i,product)
    }

    product = 1
    val revArray = arr.reversedArray()
    var productLeftArray :Array<Int?> = arrayOfNulls<Int>(arr.size)
    for (i in 0..revArray.size-1){
        product *= revArray[i]
        productLeftArray.set(i,product)
    }
    productLeftArray = productLeftArray.reversedArray()

    val outputArray = arrayOfNulls<Int>(arr.size)
    for(i in 0..arr.size-1){
        if(i == 0)
            outputArray.set(i, productLeftArray[i+1])
        else if(i ==  arr.size-1)
            outputArray.set(i, productRightArray[i-1])
        else
            outputArray.set(i, productRightArray[i-1]!!*productLeftArray[i+1]!!)

    }
    return outputArray
}