package `11-20`

// Given an integer k and a string s,
// find the length of the longest substring that contains at most k distinct characters.
//
// For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".

fun getMaxSubstringRecursive(str:String, k:Int):Pair<Pair<String,String>,HashSet<Char>>
{
    var distinctChars = hashSetOf<Char>()
    if(str.length <= k){
        str.forEach {char ->
            distinctChars.add(char)
        }
        return Pair(Pair(str,str), distinctChars)
    }

    else{
        val firstChar = str.first()

        val pair = getMaxSubstringRecursive(str.drop(1), k)
        var maxString = pair.first.first
        var prevGoingOnString = pair.first.second

        distinctChars = pair.second

        if(distinctChars.contains(firstChar)) {
            prevGoingOnString = firstChar + prevGoingOnString
        }

        else{
            while(distinctChars.size == k) {
                val lastChar = prevGoingOnString.last()
                var count = 0
                prevGoingOnString.forEach { char ->
                    if (char == lastChar)
                        count++
                }

                if (count == 1) {
                    distinctChars.remove(lastChar)
                }
                prevGoingOnString = prevGoingOnString.dropLast(1)
            }

            distinctChars.add(firstChar)
            prevGoingOnString = firstChar + prevGoingOnString
        }

        if(prevGoingOnString.length >= maxString.length)
            maxString = prevGoingOnString
        return Pair(Pair(maxString,prevGoingOnString), distinctChars)
    }

}

fun getMaxSubstringFromK(str: String, k: Int):String = getMaxSubstringRecursive(str, k).first.first

fun main(){
    print(getMaxSubstringRecursive("aaabcba", 2).first.first)
}