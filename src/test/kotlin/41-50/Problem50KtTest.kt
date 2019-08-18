import `41-50`.ExpressionNode
import `41-50`.getValueFromExpressionTree
import org.junit.Test

import org.junit.Assert.*

class Problem50KtTest {

    @Test
    fun getValueFromExpressionTree_1() {
        val tree = ExpressionNode(
            '*', ExpressionNode('+', ExpressionNode('3'), ExpressionNode('2')),
            ExpressionNode('+', ExpressionNode('4'), ExpressionNode('5'))
        )
        assertEquals(45, getValueFromExpressionTree(tree))
    }

    @Test
    fun getValueFromExpressionTree_2() {
        val tree = ExpressionNode('+', ExpressionNode('4'), ExpressionNode('5'))
        assertEquals(9, getValueFromExpressionTree(tree))
    }

    @Test
    fun getValueFromExpressionTree_3() {
        val tree = ExpressionNode('5')
        assertEquals(5, getValueFromExpressionTree(tree))
    }
}

