import `41-50`.StackList
import org.junit.Test

import org.junit.Assert.*

class Problem43KtTest {

    @Test
    fun stackOperation_1() {
        val newStack = StackList()
        newStack.push(2)
        newStack.push(4)
        newStack.push(3)
        assertEquals(3,newStack.pop())
        assertEquals(4,newStack.pop())
        assertEquals(2,newStack.pop())
        assertEquals(null,newStack.pop())
        newStack.push(5)
        newStack.push(1)
        assertEquals(5,newStack.max())
    }

    @Test
    fun stackOperation_2() {
        val newStack = StackList()
        newStack.push(10)
        newStack.push(3)
        newStack.push(2)
        newStack.push(5)
        assertEquals(10,newStack.max())
        newStack.pop()
        assertEquals(10,newStack.max())
        newStack.pop()
        assertEquals(10,newStack.max())
        newStack.pop()
        assertEquals(10,newStack.max())
        newStack.pop()
        assertEquals(null,newStack.max())

    }
}