import `21-30`.LockBinaryTreeNode
import org.junit.Test
import `21-30`.rootNode

import org.junit.Assert.*


class Problem24KtTest {
    /*
    Tree:
          2
        /   \
      1      3
     / \    / \
    0   5  7   8

     */


    @Test
    fun isLocked() {
        rootNode = LockBinaryTreeNode(
            2,
            false,
            LockBinaryTreeNode(
                1,
                false,
                LockBinaryTreeNode(0, false),
                LockBinaryTreeNode(5, false)
            ),
            LockBinaryTreeNode(
                3,
                false,
                LockBinaryTreeNode(7, false),
                LockBinaryTreeNode(8, true)
            )
        )
        assertEquals(false, rootNode!!.child.first!!.isNodeLocked())
    }

    @Test
    fun lockNode() {
        rootNode = LockBinaryTreeNode(
            2,
            false,
            LockBinaryTreeNode(
                1,
                false,
                LockBinaryTreeNode(0, false),
                LockBinaryTreeNode(5, false)
            ),
            LockBinaryTreeNode(
                3,
                false,
                LockBinaryTreeNode(7, false),
                LockBinaryTreeNode(8, true)
            )
        )
        val nodeA = rootNode!!.child.second!!
        assertEquals(false, nodeA.lockNode())
    }

    @Test
    fun unlockNode() {
        rootNode = LockBinaryTreeNode(
            2,
            false,
            LockBinaryTreeNode(
                1,
                true,
                LockBinaryTreeNode(0, false),
                LockBinaryTreeNode(5, false)
            ),
            LockBinaryTreeNode(
                3,
                false,
                LockBinaryTreeNode(7, false),
                LockBinaryTreeNode(8, true)
            )
        )
        val nodeA = rootNode!!.child.first!!
        assertEquals(true, nodeA.unlockNode())
    }
}