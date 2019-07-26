//package `21-30`

import java.lang.Error

/*
Given a singly linked list and an integer k, remove the kth last element from the list. k is guaranteed to be smaller than the length of the list.

The list is very long, so making more than one pass is prohibitively expensive.

Do this in constant space and in one pass.

 */

class SLNode {
    val value: Any
    var nextNode: SLNode? = null

//    constructor(value:Any, nextNode: `21-30`.SLNode?){
//        this.value = value
//        this.nextNode = nextNode
//    }

    constructor(value:Any){
        this.value = value
    }
}

class LinkedListNew{
    val first: SLNode?
    var last: SLNode?

    constructor(value:Any){
        this.first = SLNode(value)
        this.last = this.first
    }

    fun addNode(value: Any){
        this.last!!.nextNode = SLNode(value)
        this.last = this.last!!.nextNode
    }
}

fun removeKthLastNode(slList: LinkedListNew, k:Int): LinkedListNew {
    var current = slList.first

    try{
        for(i in 1..k-1){
            current = current!!.nextNode
        }
    }
    catch (e:Error){
        error("K can't be more than list length")
    }

    var kthLastNode = slList.first
    var kthLastBeforeNode = slList.first

    while(current!!.nextNode != null){
        kthLastBeforeNode = kthLastNode
        kthLastNode = kthLastNode!!.nextNode
        current = current.nextNode
    }
                                                                //     Prev: prevNode -> kthLastNode -> nextNode
    kthLastBeforeNode!!.nextNode = kthLastNode!!.nextNode       //     Now: prevNode -> nextNode

    return slList
}

fun main(){
    val list = LinkedListNew(1)
    list.addNode(2)
    list.addNode(3)
    list.addNode(4)
    list.addNode(5)

    val newList = removeKthLastNode(list, 3)
    println(newList.first!!.nextNode!!.value)
}

/*
Solution:
Make class for Node and Linked List, add function for adding th nodes in it.
In function `21-30`.removeKthLastNode, k is less than  length of list  hence we will traverse till k, making first as kthLastNode.
Introduce variable for node previous to kthLastNode and put the value  of kthLastNode in iteration making kthLastNode next one.
Hence we  are traversing all list nodes in one pass and in constant space.
 */