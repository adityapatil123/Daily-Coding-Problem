package `31-40`

import kotlin.math.log10

/*
Suppose you are given a table of currency exchange rates, represented as a 2D array.
Determine whether there is a possible arbitrage:
that is, whether there is some sequence of trades you can make, starting with some amount A of any currency,
so that you can end up with some amount greater than A of that currency.

There are no transaction costs and you can trade fractional quantities.
*/

fun isThereArbitrage(arrayOfArrays:Array<Array<Int>>):Boolean {
    val transformedGraph = arrayListOf<Array<Double>>()
    arrayOfArrays.forEach { row ->
        val newRow: Array<Double> = row.map { num ->
            -log10(num.toDouble())
        }.toTypedArray()
        transformedGraph.add(newRow)
    }

    val n = transformedGraph.size
    val minDistances = arrayListOf<Double>()
    for (i in 1..n)
        minDistances.add(Double.MAX_VALUE)

    minDistances[0] = 0.0

//    Relax edges |n - 1| times
    for (p in 1..(n - 1)) {

        for (i in 0..(n - 1)) {
            for (j in 0..(n - 1)) {
                if(minDistances[j] != minDistances[i] + transformedGraph[i][j])
                    minDistances[j] = minDistances[i] + transformedGraph[i][j]
            }
        }
    }

//    If we can still relax edges, then we have a negative cycle
    for (i in 0..(n - 1)) {
        for (j in 0..(n - 1)) {
            if(minDistances[j] != minDistances[i] + transformedGraph[i][j])
                return true
        }
    }
    return false
}