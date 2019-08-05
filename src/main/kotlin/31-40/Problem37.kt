package `31-40`/*
The power set of a set is the set of all its subsets.
Write a function that, given a set, generates its power set.

For example, given the set {1, 2, 3}, it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.

You may also use a list or array to represent a set.
 */

fun getPowerSet(givenSet:Array<Int>):Array<Array<Int>> {
    val powerSet = ArrayList<Array<Int>>()
    powerSet.add(emptyArray())

    for(i in 0..givenSet.size-1){
        val subset = arrayListOf<Int>()
        for(j in i..givenSet.size-1) {
            subset.add(givenSet[j])
            powerSet.add(subset.toTypedArray())
        }
    }
    return powerSet.toTypedArray()
}

fun getPowerSet2(givenSet:Array<Int>):Array<Array<Int>>
{
    if(givenSet.isEmpty())
        return arrayOf(emptyArray())

    val powerSet = ArrayList<Array<Int>>()
    val current = givenSet[0]
    val childPowerSet = getPowerSet(givenSet.sliceArray(1..givenSet.size - 1))

    powerSet.addAll(childPowerSet)

    childPowerSet.forEach { set ->
        val newArrayList = arrayListOf<Int>()
        newArrayList.add(current)
        newArrayList.addAll(set)
        powerSet.add(newArrayList.toTypedArray())
    }

    return powerSet.toTypedArray()
}

fun main(){
    getPowerSet2(arrayOf(1, 2, 3)).forEach { array ->
        array.forEach { print("\t" + it) }
        println()
    }
}