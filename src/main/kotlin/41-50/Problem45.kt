package `41-50`/*
This problem was asked by Two Sigma.

Using a function rand5() that returns an integer from 1 to 5 (inclusive) with uniform probability,
implement a function rand7() that returns an integer from 1 to 7 (inclusive).

 */

fun rand5():Int
{
    val rdm = 5 * Math.random()
    return rdm.toInt() + 1
}

fun rand7():Int
{
    val i = 5* rand5() + rand5() - 5  // uniformly samples between 1-25
    if(i < 22)
        return i % 7 + 1
    else
        return rand7()
}

fun main()
{
    val noOfCases = 10000000
    val arrayOfNumberRepetition = arrayOf(0,0,0,0,0,0,0)
    for(i in 1..noOfCases){
        val num = rand7()
        arrayOfNumberRepetition[num-1]++
    }

    val prob = 1.0/7
    val probRounded = roundTillDecimal3(prob)
    println("Probability Expected is 1/7 = "+probRounded)
    val probForAllElem = arrayOfNumberRepetition.map { roundTillDecimal3(it.toDouble() / noOfCases) }
    println("Probability got for 1-7 : "+probForAllElem)
}

fun roundTillDecimal3(num:Double) = Math.round(num * 1000.0) / 1000.0