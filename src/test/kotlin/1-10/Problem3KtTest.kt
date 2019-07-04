import org.junit.Assert.*
import org.junit.Test

class Problem3KtTest{
    @Test
    fun testProblem3_1(){
        val node = Node("root", Node("left", Node("left.left")), Node("right"))
        assertEquals("left", deSerialise(serialise(node)).left!!.value)
    }

    @Test
    fun testProblem3_2(){
        val node = Node("root", Node("left", Node("left.left")), Node("right"))
        assertEquals("left.left", deSerialise(serialise(node)).left!!.left!!.value)
    }
}