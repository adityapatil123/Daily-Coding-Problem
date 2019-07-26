package `21-30`

//import com.sun.org.apache.xpath.internal.operations.Bool

/*
Implement locking in a binary tree.
A binary tree node can be locked or unlocked only if all of its descendants or ancestors are not locked.

Design a binary tree node class with the following methods:

- is_locked, which returns whether the node is locked
- lock, which attempts to lock the node. If it cannot be locked, then it should return false. Otherwise, it should lock it and return true.
- unlock, which unlocks the node. If it cannot be unlocked, then it should return false. Otherwise, it should unlock it and return true.

You may augment the node to add parent pointers or any other property you would like.
You may assume the class is used in a single-threaded program, so there is no need for actual locks or mutexes. Each method should run in O(h), where h is the height of the tree.
 */

var rootNode: LockBinaryTreeNode? = null

class LockBinaryTreeNode{
    val value:Int
    val child:Pair<LockBinaryTreeNode?, LockBinaryTreeNode?>
    var isLocked:Boolean

    constructor(value:Int, isLocked:Boolean, leftNode: LockBinaryTreeNode?, rightNode: LockBinaryTreeNode?){
        this.value = value
        this.isLocked = isLocked
        this.child = Pair(leftNode, rightNode)
    }

    constructor(value:Int, isLocked:Boolean){
        this.value = value
        this.isLocked = isLocked
        this.child = Pair(null, null)
    }

    fun isNodeLocked():Boolean
    {
        return this.isLocked
    }

    fun lockNode():Boolean
    {
        if(this.checkIfNodeCanBeLockedOrUnlocked(this.value)) {
            this.isLocked = true
            return true
        }
        else return false
    }

    fun unlockNode():Boolean
    {
        if(this.checkIfNodeCanBeLockedOrUnlocked(this.value)) {
            this.isLocked = false
            return true
        }
        else return false
    }

    fun checkIfNodeCanBeLockedOrUnlocked(nodeVal:Int):Boolean = rootNode!!.checkIfAncestorsAreUnlocked(nodeVal) && this.checkIfDescedantsAreUnlocked()


    fun checkIfAncestorsAreUnlocked(nodeVal: Int):Boolean
    {
        if(this.value == nodeVal){
            return true
        }

        if(this.isLocked)
            return false
        else{
            val child = this.child
            if(child.first!=null)
                return child.first!!.checkIfAncestorsAreUnlocked(nodeVal) || child.second!!.checkIfAncestorsAreUnlocked(nodeVal)
            else return false
        }
    }

    fun checkIfDescedantsAreUnlocked():Boolean
    {
        val child = this.child
        if(child.first == null)
            return true
        else{
            if(child.first!!.isLocked || child.second!!.isLocked)
                return false
            else
                return child.first!!.checkIfDescedantsAreUnlocked() && child.second!!.checkIfDescedantsAreUnlocked()
        }
    }
}

fun main(){
    rootNode = LockBinaryTreeNode(
        2,
        false,
        LockBinaryTreeNode(
            1,
            false,
            LockBinaryTreeNode(0, false),
            LockBinaryTreeNode(5, false)
        ),
        LockBinaryTreeNode(3, false, LockBinaryTreeNode(7, false), LockBinaryTreeNode(8, true))
    )
    /*
    Tree:
          2
        /   \
      1      3
     / \    / \
    0   5  7   8

     */

    println(rootNode!!.isNodeLocked())
    println(rootNode!!.child.second!!.child.second!!.isLocked)

    val nodeA = rootNode!!.child.second!!
    println(nodeA.lockNode())
    println(rootNode!!.child.first!!.isLocked)
}

/*
Create global variable RootNode which will be nothing but root node of Tree, which can be called from anywhere.
Make class for node and have properties required for making node and make constructors for the same.
Function isNodeLocked can be simply checked by accessing property isLocked.
For functions lock and unlock nodes, we have to first see  if all ancestors and descendants are unlocked or not.
For checking ancestors, we will parse whole tree from starting until we get the element.
For  descendants, it is simple enough to just parse tree from that node.
 */