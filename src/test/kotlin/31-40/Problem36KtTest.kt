import `31-40`.BSTNode
import `31-40`.getSecondLargestNode
import org.junit.Test

import org.junit.Assert.*

class Problem36KtTest {

    /*
       8
     /   \
    3    10
     */
    @Test
    fun getSecondLargestNode_1() {
        val root = BSTNode(
            8,
            BSTNode(3, null, null),
            BSTNode(10, null, null)
        )
        assertEquals(8, getSecondLargestNode(root))
    }

    /*
       8
     /   \
    3    10
           \
           14
          /
         13
     */
    @Test
    fun getSecondLargestNode_2() {
        val root = BSTNode(
            8,
            BSTNode(3, null, null),
            BSTNode(
                10,
                null,
                BSTNode(14, BSTNode(13, null, null), null)
            )
        )
        assertEquals(13, getSecondLargestNode(root))
    }
}