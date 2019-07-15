package `11-20`/*
Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.

For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.

In this example, assume nodes with the same value are the exact same node objects.

Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
 */

class LLNode{
    val value:Int
    var nextNode: LLNode?

    constructor(value:Int, nextNode: LLNode?){
        this.value = value
        this.nextNode = nextNode
    }
}

class SinglyLinkedList{
    val first: LLNode?
    var current: LLNode

    constructor(value: Int){
        this.first = LLNode(value, null)
        this.current = this.first
    }

    fun addToList(value: Int){
        val newNode = LLNode(value, null)
        this.current.nextNode = newNode
        this.current = newNode
    }
}

fun findIfNodeAlreadyPresent(linkedList: SinglyLinkedList?, value: Int):Pair<Boolean, SinglyLinkedList?>
{
    var repeatingList: SinglyLinkedList? = null
    var current: LLNode? = linkedList!!.first
    var hasIntersectingElemFound = false
    var temp = current

    while (current!= null){
        if(current.value == value){
            hasIntersectingElemFound = true
            repeatingList = SinglyLinkedList(value)
        }
        else if(hasIntersectingElemFound)
            repeatingList!!.addToList(current.value)
        temp = current
        current = current.nextNode
    }
    current = temp
    return Pair(hasIntersectingElemFound,  repeatingList)
}

fun getIntersectedFirstElemValue(array1:Array<Int>, array2: Array<Int>):Int?
{
    var intersectedElemFound = false
    var intersectedElem:Int? = null

    var list1: SinglyLinkedList? = null

    for(i in 0..array1.size-1)
    {
        if(i == 0){
            list1 = SinglyLinkedList(array1[i])
        }
        else {
            list1!!.addToList(array1[i])
        }
    }

    var list2: SinglyLinkedList? = null
    for(i in 0..array2.size-1)
    {
        if(i == 0){
            val pair  = findIfNodeAlreadyPresent(list1, array2[i])
            if(pair.first == false)
                list2 = SinglyLinkedList(array2[i])
            else {
                intersectedElemFound = true
                intersectedElem = array2[i]
                break
            }
        }
        else {
            val pair  = findIfNodeAlreadyPresent(list1, array2[i])
            if(pair.first == false)
                list2!!.addToList(array2[i])
            else {
                intersectedElemFound = true
                intersectedElem = array2[i]
                list2!!.current.nextNode = pair.second!!.first
                break
            }
        }
    }

    return intersectedElem
}