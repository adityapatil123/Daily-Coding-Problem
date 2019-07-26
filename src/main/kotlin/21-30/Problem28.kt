package `21-30`

import kotlin.math.ceil

/*
Write an algorithm to justify text. Given a sequence of words and an integer line length k, return a list of strings which represents each line, fully justified.

More specifically, you should have as many words as possible in each line. There should be at least one space between each word. Pad extra spaces when necessary so that each line has exactly length k. Spaces should be distributed as equally as possible, with the extra spaces, if any, distributed starting from the left.

If you can only fit one word on a line, then you should pad the right-hand side with spaces.

Each word is guaranteed not to be longer than k.

For example, given the list of words ["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"] and k = 16, you should return the following:

["the  quick brown", # 1 extra space on the left
"fox  jumps  over", # 2 extra spaces distributed evenly
"the   lazy   dog"] # 4 extra spaces distributed evenly
 */

fun justifyText(listOfWords:Array<String>, k:Int):Array<String>{
    var str = ""

    var lineWords = arrayListOf<String>()
    val listOfOutputStr = arrayListOf<String>()

    listOfWords.forEachIndexed { count, word ->
        if(word.length >= k)
            error("Word length can't be more than 'K'")

        if(str.isEmpty()){
            str = word
            lineWords = arrayListOf()
        }
        else
            str += " " + word

        lineWords.add(word)

        if(count < listOfWords.size-1) {
            if (str.length + listOfWords[count + 1].length >= k) {
                listOfOutputStr.add(getLineString(k, lineWords, str))
                str = ""
            }
        }
    }

    if(str.isNotEmpty())
        listOfOutputStr.add(getLineString(k, lineWords, str))

    return listOfOutputStr.toTypedArray()

}


fun getLineString(k:Int, lineWords:ArrayList<String>, str:String):String
{
    var noOfSpaces = k - str.length + lineWords.size - 1
    val maxSpaces = ceil(noOfSpaces.toFloat() / (lineWords.size -1)).toInt()
    var spaces = 0
    var strLine = ""

    for(i in 0..lineWords.size-1){
        if(i == 0)
            strLine = lineWords[i]
        else{
            if(noOfSpaces >= maxSpaces) {
                noOfSpaces -= maxSpaces
                spaces = maxSpaces
            }
            else
                spaces = noOfSpaces

            for(count in 1..spaces)
                strLine += " "        // Adding spaces (k - wordLength)

            strLine += lineWords[i]

        }
    }

    if(strLine.length < k){
        spaces = k - str.length
        for(count in 1..spaces)
            strLine += " "
    }


    return strLine
}

/*
- Here, we can solve using sliding window approach.
- Add words normally(with one space) till strLength k.
- When it exceeds k, make stringLine of those words adjusting spaces as per asked.
- Return the list of those stringLines.
 */