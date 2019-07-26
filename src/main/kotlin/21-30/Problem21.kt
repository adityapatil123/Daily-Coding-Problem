package `21-30`/*
Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.

For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
 */

val freeIntervals = arrayListOf<Pair<Int?, Int?>>()
fun minimumRequiredRooms(intervalsArray:Array<Pair<Int, Int>>):Int
{
    var noOfRoomsRequired = 0
    for(i in 0..intervalsArray.size-1)
    {
        val start = intervalsArray[i].first
        val end = intervalsArray[i].second
        if(i == 0) {
            freeIntervals.add(Pair(null, start))
            freeIntervals.add(Pair(end, null))
            noOfRoomsRequired++
        }
        else{
            if(isNewRoomRequired(start, end))
                noOfRoomsRequired++
        }
    }


    return noOfRoomsRequired
}


fun isNewRoomRequired(start:Int, end:Int):Boolean
{
    var index = 0
    freeIntervals.forEach { freeInterval ->
        val startOfFree = freeInterval.first
        val endOfFree = freeInterval.second

        if(startOfFree == null){
            if(end < endOfFree!!){
                updateFreeIntervals(start, end, startOfFree, endOfFree, index)
                return false
            }
        }
        else if(endOfFree == null){
            if(start > startOfFree){
                updateFreeIntervals(start, end, startOfFree, endOfFree, index)
                return false
            }
        }
        else{
            if(start > startOfFree && end < endOfFree){
                updateFreeIntervals(start, end, startOfFree, endOfFree, index)
                return false
            }
        }
        index++
    }
    freeIntervals.add(Pair(null, start))
    freeIntervals.add(Pair(end, null))
    return true
}

fun updateFreeIntervals(start: Int, end: Int, startOfFree:Int?, endOfFree:Int?, index:Int)
{
    freeIntervals.removeAt(index)
    freeIntervals.add(Pair(startOfFree, start))
    freeIntervals.add(Pair(end, endOfFree))
}


/* Solution:
getFreeIntervals as global arraylist which has intervals which are free.
isNewRoomRequired function will tell if particular interval can be fitted in free intervals Hence newRequired or not. Here, getFreeIntervals is also updated.
updateFreeIntervals function is used for not having repetition of code.
minimumRequiredRooms will add in noOfRooms if newRequired or not
 */