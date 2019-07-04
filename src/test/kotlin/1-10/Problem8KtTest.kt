import org.junit.Assert.*
import org.junit.Test


class Problem8KtTest{
    @Test
    fun testProblem8_1(){
        val tree = Node2(0, Node2(1,   Node2(1, Node2(1, null, null),
                                                            Node2(1, null, null)),
                                            Node2(0, null, null)),
                            Node2(0, null, null))
        assertEquals(5, findNoOfUnivalTrees(tree))
    }

    @Test
    fun testProblem8_2(){
        val tree = null
        assertEquals(0, findNoOfUnivalTrees(tree))
    }

    @Test
    fun testProblem8_3(){
        val tree = Node2(0,null, null)
        assertEquals(1, findNoOfUnivalTrees(tree))
    }
}