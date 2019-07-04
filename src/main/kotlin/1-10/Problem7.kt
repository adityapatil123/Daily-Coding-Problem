//Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
//
//For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
//
//You can assume that the messages are decodable. For example, '001' is not allowed.

fun getNoOfDecodingWays(str:String):Int{
    val charList = str.toCharArray()
    val intList:List<Int> = charList.map{ it.toInt() - 48 }

    return getRecursiveDecoding(intList).first!!
}

fun getRecursiveDecoding(list: List<Int>):Pair<Int?,Int>
{
    val listSize = list.size
    var last = 0
    var noOfWays = 0

    if(list.isEmpty())
        return Pair(null, 0)
    else if(listSize == 1)
        return Pair(1, list[0])
    else{
        val tailList = list.slice(1..listSize-1)
        noOfWays = getRecursiveDecoding(tailList).first!!
        last = getRecursiveDecoding(tailList).second
        val num =  list[0]*10 + last
        if(num > 0 && num < 27)
            noOfWays++
        return Pair(noOfWays, list[0])
    }
}

fun main(){
    println(getNoOfDecodingWays(""))
}