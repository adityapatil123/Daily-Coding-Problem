package `41-50`
/*
This problem was asked by Amazon.

Implement a stack that has the following methods:

push(val), which pushes an element onto the stack
pop(), which pops off and returns the topmost element of the stack. If there are no elements in the stack, then it should throw an error or return null.
max(), which returns the maximum value in the stack currently. If there are no elements in the stack, then it should throw an error or return null.
Each method should run in constant time.
 */

class StackNode{
    val value:Int
    var prev: StackNode?
    var maxTillNode:Int

    constructor(value:Int){
        this.value = value
        this.prev = null
        this.maxTillNode = value
    }
}

class StackList{
    var last: StackNode? = null

    fun push(value: Int)
    {
        var maxElem:Int = value
        if(this.last != null && this.last!!.maxTillNode > value)
            maxElem = this.last!!.maxTillNode

        val tempLast = this.last
        this.last = StackNode(value)
        this.last!!.prev = tempLast
        this.last!!.maxTillNode = maxElem
    }

    fun pop():Int?
    {
        if(this.last == null)
            return null
        else{
            val popElem = this.last!!.value
            this.last = this.last!!.prev
            return popElem
        }
    }

    fun max():Int?
    {
        if(this.last == null)
            return null
        else{
            val maxElem = this.last!!.maxTillNode
            return maxElem
        }
    }
}

fun main()
{
    val newStack = StackList()
    newStack.push(2)
    newStack.push(4)
    newStack.push(3)
    println(newStack.pop())
    println(newStack.pop())
    println(newStack.pop())
    println(newStack.pop())
    newStack.push(1)
    println(newStack.max())
}