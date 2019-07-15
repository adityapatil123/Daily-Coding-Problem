package `11-20`

//You run an e-commerce website and want to record the last N order ids in a log.
// Implement a data structure to accomplish this, with the following API:
//
// record(order_id): adds the order_id to the log
// get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
//You should be as efficient with time and space as possible.

var bigN = 2
val logList = arrayListOf<Int>()

fun record(orderId:Int){
    if(logList.size == bigN)
        logList.removeAt(0)
    logList.add(orderId)

}

fun getLast(i:Int):Int?
{
    if(i <= bigN)
        return logList[i-1]
    return null
}


