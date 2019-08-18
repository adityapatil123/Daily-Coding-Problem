package `41-50`/*
Given an unordered list of flights taken by someone, each represented as (origin, destination) pairs, and a starting airport, compute the person's itinerary.
If no such itinerary exists, return null.
If there are multiple possible itineraries, return the lexicographically smallest one.
All flights must be used in the itinerary.

For example, given the list of flights [('SFO', 'HKO'), ('YYZ', 'SFO'), ('YUL', 'YYZ'), ('HKO', 'ORD')] and starting airport 'YUL', you should return the list ['YUL', 'YYZ', 'SFO', 'HKO', 'ORD'].

Given the list of flights [('SFO', 'COM'), ('COM', 'YYZ')] and starting airport 'COM', you should return null.

Given the list of flights [('A', 'B'), ('A', 'C'), ('B', 'C'), ('C', 'A')] and starting airport 'A', you should return the list ['A', 'B', 'C', 'A', 'C'] even though ['A', 'C', 'A', 'B', 'C'] is also a valid itinerary.
However, the first one is lexicographically smaller.
 */

fun findBestItinerary(unOrderedFlights:Array<Pair<String, String>>, startingPt:String):Array<String>?
{
    val set = unOrderedFlights.toHashSet()
    val list = findItineraryRecursive(set, startingPt)
    if(list == null)
        return null
    return list.toTypedArray()
}

fun getStringFromPair(path:Pair<String, String>):String = path.first + path.second

fun getLexicographicallySmallest(pathArray:Array<Pair<String, String>>):Pair<String, String>
{
    var bestPathString = getStringFromPair(pathArray[0])
    var bestPair = pathArray[0]
    pathArray.forEach { pair ->
        if(getStringFromPair(pair) < bestPathString){
            bestPathString = getStringFromPair(pair)
            bestPair = pair
        }
    }

    return bestPair
}



fun findItineraryRecursive(flightsSet:HashSet<Pair<String, String>>, startingPt: String):ArrayList<String>?
{
    val outputBestPath = arrayListOf<String>(startingPt)
    val noOfSetElements = flightsSet.size
    if(noOfSetElements == 0){
        return outputBestPath
    }

    val flightsFromStartingPt = flightsSet.filter { pair -> (pair.first == startingPt) }.toTypedArray()
    if(flightsFromStartingPt.size == 0) {
        return null
    }

    val bestPair = getLexicographicallySmallest(flightsFromStartingPt)
    flightsSet.remove(bestPair)
    val nextCheckPts = findItineraryRecursive(flightsSet, bestPair.second)
    if(nextCheckPts == null)
        return null
    else {
        outputBestPath.addAll(nextCheckPts)
        return outputBestPath
    }

}