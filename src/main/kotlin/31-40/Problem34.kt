package `31-40`/*
Given a string, find the palindrome that can be made by inserting the fewest number of characters as possible anywhere in the word.
If there is more than one palindrome of minimum length that can be made, return the lexicographically earliest one (the first one alphabetically).

For example, given the string "race", you should return "ecarace", since we can add three letters to it (which is the smallest amount to make a palindrome).
There are seven other palindromes that can be made from "race" by adding three letters, but "ecarace" comes first alphabetically.

As another example, given the string "google", you should return "elgoogle".
 */

fun isPalindrome(str:String):Boolean = (str == str.reversed())

fun findPalindromeByAddingChars(str:String):String
{
    if(isPalindrome(str))
        return str

    val lastIndex = str.length -1
    if(str[0] == str[lastIndex]) {
        return str[0] + findPalindromeByAddingChars(str.slice(1..(lastIndex - 1))) + str[0]
    }
    else{
        val pal1 = str[0] + findPalindromeByAddingChars(str.slice(1..lastIndex)) + str[0]
        val pal2 = str[lastIndex] + findPalindromeByAddingChars(str.slice(0..(lastIndex - 1))) + str[lastIndex]

        if(pal1.length < pal2.length)
            return pal1
        else if(pal2.length < pal1.length)
            return pal2

        if(pal1 < pal2)
            return pal1
        else
            return pal2
    }

}
