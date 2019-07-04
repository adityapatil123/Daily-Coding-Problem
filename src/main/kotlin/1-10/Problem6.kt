import java.util.*

//An XOR linked list is a more memory efficient doubly linked list.
// Instead of each node holding next and prev fields, it holds a field named both, which is an XOR of the next node and the previous node.
// Implement an XOR linked list; it has an add(element) which adds the element to the end, and a get(index) which returns the node at index.
//
//If using a language that has no pointers (such as Python),
// you can assume you have access to get_pointer and dereference_pointer functions that converts between nodes and memory addresses.

// I've used kotlin so just used functions 'getAddress' and 'getValueFromAddr'

class Node1{
    var value:Int
    var both:Int

    constructor(value:Int, both:Int){
        this.value = value
        this.both = both
    }

}


class XORLinkedList{
    var head:Node1? = null
    var tail:Node1? = null
    var prevTail:Node1? = null
    var length = 0

    fun add(nodeValue: Int){
        val prevTail = this.tail!!
        val valueAddr = getAddress(nodeValue)
        val prevValueAddr  = getAddress(this.tail!!.value)

        if(length == 0){
            this.head!!.value = nodeValue
            this.head!!.both = 0
            this.head = this.tail
        }
        else if(length == 1){
            this.head = Node1(this.head!!.value, 0 xor valueAddr)
            this.prevTail = Node1(this.head!!.value, 0 xor valueAddr)
            this.tail = Node1(nodeValue, prevValueAddr xor 0)
        }
        else{
            this.tail = Node1(nodeValue, prevValueAddr xor 0)
            this.prevTail = Node1(prevTail.value, prevTail.both xor valueAddr)
        }

        length++
    }

    fun getIndex(index:Int):Int
    {
        if(index >= length || index==0){
            return -1
        }
        else{
            var current:Int = this.head!!.value

            for(i in 1..index-1) {
                val addr = getAddress(current)
                current = current xor addr
            }
            return getValueFromAddr(current)
        }
        var list = LinkedList<Int>()
    }
}

fun getAddress(node: Int):Int{return 0}
fun getValueFromAddr(addr : Int):Int {return 0}