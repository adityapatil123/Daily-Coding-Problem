package `31-40`/*
This problem was asked by Dropbox.

Given the root to a binary search tree, find the second largest node in the tree.
 */

class BSTNode{
    val value:Any
    val child: Pair<BSTNode?, BSTNode?>

    constructor(value: Any, leftChild: BSTNode?, rightChild: BSTNode?){
        this.value = value
        this.child = Pair(leftChild, rightChild)
    }
}

fun getSecondLargestNode(root: BSTNode):Any
{
    var current = root
    var prev: BSTNode = root
    while(current.child.second != null){
        prev = current
        current = current.child.second!!
    }

    if(current.child.first == null)
        return prev.value
    else
        return getLargestNode(current.child.first!!).value
}

fun getLargestNode(node: BSTNode): BSTNode
{
    var current = node
    while(current.child.second != null)
        current = current.child.second!!
    return current
}