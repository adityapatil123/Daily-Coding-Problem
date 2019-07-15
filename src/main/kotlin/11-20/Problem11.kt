package `11-20`

//Implement an autocomplete system.
// That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.
//
//For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].
//
//Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.

fun autoComplete(prefix:String, array: Array<String>):Array<String>
{
    val node = CharNode('-')
    array.forEach { word ->
        node.addNode(word)
    }
    return node.find(prefix).second.toTypedArray()
}


class CharNode{
    val value:Char
    val next = mutableListOf<CharNode>()
    val suggestionList = mutableListOf<String>()

    constructor(value:Char){
        this.value = value
    }

    fun addNode(word:String){
        var exists = false

        this.next.forEach {child ->
            if(child.value == word[0]){
                exists = true
                if(word.length > 1)
                    child.addNode(word.slice(1..word.length-1))
                else
                    child.next.add(CharNode(word[0]))
            }
        }

        if(exists == false){
            val newNode = CharNode(word[0])
//            println(newNode.value)
            this.next.add(newNode)
            if(word.length > 1)
                newNode.addNode(word.slice(1..word.length-1))
        }

    }

    fun find(prefix: String):Pair<Boolean, MutableList<String>> {

        var list = mutableListOf<String>()
        var isFound = false

        if (this.value == '-') {

            this.next.forEach { child ->
                if(prefix[0]==child.value) {
                    val pair = child.find(prefix)
                    isFound = pair.first
                    if (isFound)
                        list = pair.second
                }
            }
            return Pair(isFound, list)
        }

        else {
            if (prefix[0] == this.value) {
                var flag = false

                if (prefix.length == 1)
                {
                    list = this.findAllwords()
                    return Pair(true, list)
                }

                else
                {
                    this.next.forEach { child ->
                        val pair = child.find(prefix.slice(1..prefix.length - 1))
                        isFound = pair.first
                        if (isFound) {
                            list = pair.second.map { str -> prefix.slice(0..prefix.length - 2) + str }.toMutableList()
                            flag = true
                        }
                    }
                }
                return Pair(flag, list)
            }
            return Pair(false, list)
        }

    }

    fun findAllwords():MutableList<String>{
        var wordList = mutableListOf<String>()
        val word = this.value.toString()

        if(this.next.isEmpty())
            wordList.add(word)

        else {
            this.next.forEach { child ->
                wordList = (wordList + child.findAllwords().map { childWord -> word + childWord }.toMutableList()).toMutableList()
            }
        }
        return wordList
    }

}

