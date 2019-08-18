package `41-50`/*
Given a string, find the longest palindromic contiguous substring.
If there are more than one with the maximum length, return any one.

For example, the longest palindromic substring of "aabcdcb" is "bcdcb".
The longest palindromic substring of "bananas" is "anana".
 */

fun getMaxLengthPalindrome(str:String):String
{
    if(str.isEmpty() || isPalindrome(str))
        return str

    val lastIndex = str.length - 1
    val str1 = getMaxLengthPalindrome(str.slice(1..lastIndex))
    val str2 = getMaxLengthPalindrome(str.slice(0..lastIndex - 1))

    if(str1.length > str2.length)
        return str1
    else
        return str2
}

fun isPalindrome(str: String):Boolean = (str == str.reversed())