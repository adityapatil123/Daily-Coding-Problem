package `21-30`

import java.util.*

/*
Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).

For example, given the string "([])[]({})", you should return true.

Given the string "([)]" or "((()", you should return false.
 */

fun isBracketsBalanced(str:String):Boolean
{
    val openingBrackets = arrayOf('(','{','[')
    val closingBrackets = arrayOf(')','}',']')
    val stack = Stack<Char>()

    str.forEachIndexed { index, char ->
        if(char in openingBrackets)
            stack.push(char)

        else if(char in closingBrackets){
            if(stack.size == 0)
                return false
            else{
                val prevChar = stack.peek()
                val prevCharOpeningBracketIndex = openingBrackets.indexOf(prevChar)
                val cuurentCharClosingBracketIndex = closingBrackets.indexOf(char)

                if(prevCharOpeningBracketIndex == cuurentCharClosingBracketIndex)
                    stack.pop()
                else
                    return false
            }
        }

        else
            error("'${char}' character can't be in string, character must be a bracket")

    }

    return (stack.size == 0)
}

/*
Solution:
Make arrays of opening and closing brackets.
We will use Stack data structure here.
Push to stack if opening bracket,
else check peek element if prevChar opening bracket and current char closing bracket are of same type, if yes continue otherwise return false.
After traversing whole string, check the size of stack, if zero then true otherwise false.
 */