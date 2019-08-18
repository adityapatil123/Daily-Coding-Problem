import `41-50`.getTree
import org.junit.Test

import org.junit.Assert.*

class Problem48KtTest {

    @Test
    fun getTree_1() {
        val tree =
            getTree(arrayOf('a', 'b', 'd', 'e', 'c', 'f', 'g'), arrayOf('d', 'b', 'e', 'a', 'f', 'c', 'g'))
        assertEquals(tree!!.value, 'a')
        assertEquals(tree.left!!.value,'b')
        assertEquals(tree.left!!.left!!.value,'d')
        assertEquals(tree.left!!.right!!.value,'e')
        assertEquals(tree.right!!.value,'c')
        assertEquals(tree.right!!.left!!.value,'f')
        assertEquals(tree.right!!.right!!.value,'g')
    }
}