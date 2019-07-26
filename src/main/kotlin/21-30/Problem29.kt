package `21-30`/*
Run-length encoding is a fast and simple method of encoding strings.
The basic idea is to represent repeated successive characters as a single count and character.
For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

Implement run-length encoding and decoding.
You can assume the string to be encoded have no digits and consists solely of alphabetic characters.
You can assume the string to be decoded is valid.
 */


fun encodeString(str:String):String
{
    var encodedStr = ""
    var currentChar:Char? = null
    var noOfRepetitions = 0

    str.forEach { char ->
        if(currentChar == null)
            currentChar = char
        else if(currentChar != char){
            encodedStr += noOfRepetitions.toString() + currentChar
            currentChar = char
            noOfRepetitions = 0
        }
        noOfRepetitions++
    }

    encodedStr += noOfRepetitions.toString() + currentChar
    return encodedStr
}

fun decodeString(str:String):String
{
    var decodedStr = ""
    var noOfRepetitions = 0

    str.forEachIndexed { index, char ->
        if(index % 2 == 0){  //NoOfRepetitions
            noOfRepetitions = char.toString().toInt()
        }
        else{
            for(i in 1..noOfRepetitions)
                decodedStr += char
        }
    }

    return decodedStr
}

/*
encodeString : function will traverse string through character by character,
Check if char is same as previous one, if not add noOfRepetitions and char in encodedStr.
After the loop add the remained one in encodedStr.

decodeString : function will traverse encoded string through character by character,
if at even index, get noOfRepetitions
else, add char in decodedStr noOfRepetitions times
return decodedStr
 */