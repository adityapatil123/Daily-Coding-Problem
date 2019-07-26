package `21-30`/*
Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list.
If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.

For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox", you should return ['the', 'quick', 'brown', 'fox'].

Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond",
return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].
 */


fun originalSentenceInList(array: Array<String>, str:String):Array<String>
{
    val newArray = arrayListOf<String>()
    var stringGiven = str

    array.forEach { arrayElem ->
        if(stringGiven.contains(arrayElem)) {
            newArray.add(arrayElem)
            stringGiven = stringGiven.replace(arrayElem, "")
        }
    }
    return newArray.toTypedArray()
}

fun originalSentenceInList2(array: Array<String>, str:String):Array<String>
{
    val set = array.toHashSet()
    val newArray = arrayListOf<String>()

    var word = ""
    str.forEach { char ->
        word += char
        if(set.contains(word)){
            newArray.add(word)
            word = ""
        }
    }

    return newArray.toTypedArray()
}


fun main()
{
    val string = "thequickbrownfox"
    val array = arrayOf("quick", "brown", "thequick", "the", "fox")
    originalSentenceInList2(array, string).forEach { println(it) }
}

/*
1st function:
Initialise newArray where we will add new elem if that contains in array.
For each elem of array, if string contains elem, add elem in NewArray and remove that part from string
Return that newArray.
But problem here is newArray elems are not in order as in string.

2nd function:
Instead of iterating array , here we are iterating on string.
Add character to word and check if that contains in set(for having better efficiency), If yes add elem and make word blank.
Return newArray
 */