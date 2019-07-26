package `21-30`/*
Implement regular expression matching with the following special characters:

. (period) which matches any single character
* (asterisk) which matches zero or more of the preceding element
That is, implement a function that takes in a string and a valid regular expression and returns whether or not the string matches the regular expression.

For example, given the regular expression "ra." and the string "ray", your function should return true.
The same regular expression on the string "raymond" should return false.

Given the regular expression ".*at" and the string "chat", your function should return true.
The same regular expression on the string "chats" should return false.

 */

fun checkIfStringMatchesExpression(expr:String, string: String):Boolean
{
    println("Expression : "+expr)
    println("String : "+string)
    if(expr.isEmpty())
        return false

    else{
        if(expr[0] == '*')
            error("Expression can't begin with asterisk *")

        if(expr.length == 1){
            if(expr[0] == string[0] || expr[0]=='.') {
                if(string.length == 1)
                    return true
                return false
            }
        }

        if(expr[1] == '*'){

            if(expr[0] == '.'){

                if(expr.length == 2)
                    return true
                else{
                    var i = 0
                    while(true){
                        if(string[i] == expr[2])
                            return checkIfStringMatchesExpression(
                                expr.slice(2..expr.length - 1),
                                string.slice(i..string.length - 1)
                            )
                        i++
                    }
                }
            }

            else {
                var i = 0
                while (true) {
                    if (string[i] != expr[0]) {
                        if(expr.length == 2)
                            return false
                        // else
                        return checkIfStringMatchesExpression(
                            expr.slice(2..expr.length - 1),
                            string.slice(i..string.length - 1)
                        )
                    }
                    i++
                }
            }

        }
        else{
            if(expr[0] == string[0] || expr[0]=='.')
                return checkIfStringMatchesExpression(
                    expr.slice(1..expr.length - 1),
                    string.slice(1..string.length - 1)
                )
            else
                return false
        }

    }

}

/*
Solution:

We will break expression and string and use them in recursive function.
Its all about conditions
1. If Expr is empty, return false.
2. Expr cant begin with *
3. If expr length is 1 then string has to be of length 1.
4. Check if 2nd element is '*', and if 1st is '.', then check till next elem is of expr gets in string.
   And if 1st is not '.', then check till repetition of that character.
5. If 2nd is not '*', just check simply if that 1st char in expr is same as 1st char in string, except for '.'
6. Program will break into recursions step by step and base-case will be 3rd case.

 */