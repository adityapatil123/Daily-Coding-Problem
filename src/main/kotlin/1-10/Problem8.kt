// A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.

// Given the root to a binary tree, count the number of unival subtrees.

// For example, the following tree has 5 unival subtrees:

//       0
//      / \
//     1   0        // 1st '0'
//    / \
//   1   0          // 2nd '1', 3rd '0'
//  / \
// 1   1            // 4th '1', 5th '1'

class Node2{
    val value:Int
    val child1:Node2?
    val child2:Node2?

    constructor(value:Int, next1:Node2?, next2:Node2?){
        this.value = value
        this.child1 = next1
        this.child2 = next2
    }
}


fun getNoOfUnivalTreesAndFlag(root:Node2?):Pair<Int,Boolean>
{
//    println("here")
    if(root == null)
        return Pair(0,false)

    var noOfTrees = 0
    var current = root
    var flag1:Boolean = false
    var flag2:Boolean = false
    val value = current!!.value

    if(current!!.child1!=null) {
        if (value == current.child1!!.value)
            flag1 = true
        else flag1 = false
        val temp = current
        current = current.child1
        val univTreeFlag = getNoOfUnivalTreesAndFlag(current)
        noOfTrees += univTreeFlag.first
        flag1 = flag1 and univTreeFlag.second
        current = temp
    }

    if(current!!.child2!=null) {
        if (value == current.child2!!.value)
            flag2 = true
        else flag2 = false
        val temp = current
        current = current.child2
        val univTreeFlag = getNoOfUnivalTreesAndFlag(current)
        noOfTrees += univTreeFlag.first
        flag2 = flag2 and univTreeFlag.second
        current = temp
    }

    if(current!!.child1==null && current!!.child2==null){
        flag1 = true
        flag2 = true
//        println("No child")
        noOfTrees++
    }
    else{
        if(flag1 and flag2)
            noOfTrees++
    }

    return Pair(noOfTrees,flag1 and flag2)
}

fun findNoOfUnivalTrees(tree:Node2?):Int = getNoOfUnivalTreesAndFlag(tree).first

fun main(args:Array<String>){
    val tree = Node2(0, Node2(1,   Node2(1, Node2(1, null, null),
                                                        Node2(1, null, null)),
                                    Node2(0, null, null)),
                        Node2(0, null, null))
    println(findNoOfUnivalTrees(tree))
}




