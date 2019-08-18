package `41-50`

/*
Suppose an arithmetic expression is given as a binary tree.
Each leaf is an integer and each internal node is one of '+', '−', '∗', or '/'.

Given the root to such a tree, write a function to evaluate it.

For example, given the following tree:

    *
   / \
  +    +
 / \  / \
3  2  4  5
You should return 45, as it is (3 + 2) * (4 + 5).
 */

class ExpressionNode{
    val value:Char
    var left: ExpressionNode? = null
    var right: ExpressionNode? = null

    constructor(value:Char, left: ExpressionNode?, right: ExpressionNode?){
        this.value = value
        this.left = left
        this.right = right
    }

    constructor(value: Char){
        this.value = value
    }
}

fun getValueFromExpressionTree(rootNode: ExpressionNode):Int
{
    // Check if character is digit
    if(rootNode.value.isDigit())
        return Integer.parseInt(rootNode.value.toString())

    // Check if children are digits
    val leftValue:Int
    val rightValue:Int
    val operationSign = rootNode.value
    if(rootNode.left!!.value.isDigit())
        leftValue = Integer.parseInt(rootNode.left!!.value.toString())
    else
        leftValue = getValueFromExpressionTree(rootNode.left!!)

    if(rootNode.right!!.value.isDigit())
        rightValue = Integer.parseInt(rootNode.right!!.value.toString())
    else
        rightValue = getValueFromExpressionTree(rootNode.right!!)

    return getResultOfOperation(leftValue, rightValue, operationSign)
}

fun getResultOfOperation(left: Int, right: Int, char: Char):Int
{
    val result:Int
    if(char == '+')
        result = left + right
    else if(char == '-')
        result = left - right
    else if(char == '*')
        result = left * right
    else
        error("Not possible operation")

    return result
}