//Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.
//
//For example, given the following Node class

//class Node:
//    def __init__(self, val, left=None, right=None):
//          self.val = val
//          self.left = left
//          self.right = right

//The following test should pass:

//node = Node('root', Node('left', Node('left.left')), Node('right'))
//assert deserialize(serialize(node)).left.left.val == 'left.left'

import java.util.*

class Node{
    var value:String
    var left:Node? = null
    var right:Node? = null

    constructor(value: String) {
        this.value = value
        this.left = null
        this.right = null
    }

    constructor(value: String, left:Node) {
        this.value = value
        this.left = left
        this.right = null
    }

    constructor(value:String, left:Node,right:Node){
        this.value = value
        this.left = left
        this.right = right
    }

//    constructor(value:String, left:Node){
//        this.value = value
//        this.left = left
//    }
}

fun serialise(root: Node?):String
{
//    var flag:Boolean = false
//    if(root!!.value == "root")
//        flag = true

    var string= ""
    var stringLeft = ""
    var stringRight = ""

    if(root == null){
        return ""
    }
    else{
        string += "${root.value}-"
        stringLeft = serialise(root.left)
        stringRight = serialise(root.right)

        string += serialise(root.left)
        if(stringLeft!="" && stringRight=="")
            string += "-"
        string += serialise(root.right)

        return string
    }
}

fun deSerialise(str:String):Node
{
    val arr =str.split("-").toMutableList()
    arr.removeAt(arr.size-1)
//    arr.forEach{println(it)}
    val queue: Queue<String> = LinkedList<String>(arr)
    val node = deSerialiseNode(queue)!!


    return node


}

fun deSerialiseNode(nodes: Queue<String>):Node?{
//    println(nodes.peek())
    if(nodes.peek()!= null){
        var nextNode = nodes.remove()
        if(nextNode == null)
            return null
        var node = Node(nextNode)
        node.left =  deSerialiseNode(nodes)
        node.right =  deSerialiseNode(nodes)
        return node

    }
    return null
}

