package `41-50`/*
Given pre-order and in-order traversals of a binary tree, write a function to reconstruct the tree.

For example, given the following preorder traversal:

[a, b, d, e, c, f, g]

And the following inorder traversal:

[d, b, e, a, f, c, g]

You should return the following tree:

    a
   / \
  b   c
 / \ / \
d  e f  g
 */

class BinaryTreeNode{
    val value:Char
    var left: BinaryTreeNode? = null
    var right: BinaryTreeNode? = null

    constructor(value:Char){
        this.value = value
    }
}

fun getTree(preOrder:Array<Char>, inOrder:Array<Char>): BinaryTreeNode?
{
    if(preOrder.size != inOrder.size && preOrder.isEmpty())
        return null

    val rootChar = preOrder[0]
    val rootNode = BinaryTreeNode(rootChar)

    if(preOrder.size == 1)
        return rootNode

    inOrder.forEachIndexed { index, char ->
        if(rootChar == char){
            rootNode.left = getTree(preOrder.sliceArray(1..index), inOrder.sliceArray(0..index - 1))
            rootNode.right = getTree(
                preOrder.sliceArray(index + 1..preOrder.size - 1),
                inOrder.sliceArray(index + 1..preOrder.size - 1)
            )
        }
    }

    return rootNode
}