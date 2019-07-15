package `11-20`

//There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time.
// Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.
//
//For example, if N is 4, then there are 5 unique ways:
//
//1, 1, 1, 1
//2, 1, 1
//1, 2, 1
//1, 1, 2
//2, 2

//What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X?
// For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.

fun getStepsLastSecondLast(n:Int):Pair<Int,Int>
{
    if(n == 1)
        return Pair(1,1)
    else{
        val pair = getStepsLastSecondLast(n - 1)
        var lastNoOfSteps = pair.first
        var secondLastNoOfSteps = pair.second

        val temp = secondLastNoOfSteps
        secondLastNoOfSteps = lastNoOfSteps
        lastNoOfSteps += temp
        return Pair(lastNoOfSteps,secondLastNoOfSteps)
    }
}


// Time Complexity = O(n)
fun getStepsFor1_2(n:Int):Int?
{
    if(n > 0)
        return getStepsLastSecondLast(n).first
    else
        return null
}

// Time Complexity = O(n2)
fun getStepsForAny(n:Int, stepSizes: Array<Int>):Int?
{
    var steps = 0
    if(n < stepSizes.min()!!)
        return 0

    stepSizes.forEach { stepSize ->
        if(n == stepSize){
            steps++
        }
        else if(n > stepSize){
            steps += getStepsForAny(n - stepSize, stepSizes)!!
        }
    }
    return steps
}

val double:(Int)->Int = {num -> num *2}

var add = fun(num1:Int,num2:Int):   Int{
    return num1 + num2
}