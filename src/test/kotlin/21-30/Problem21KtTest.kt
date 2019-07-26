import `21-30`.minimumRequiredRooms
import org.junit.Test

import org.junit.Assert.*

class Problem21KtTest {

    @Test
    fun minimumRequiredRooms_1() {
        val array = arrayOf(Pair(30,75), Pair(0,50), Pair(60,150))
        assertEquals(2, minimumRequiredRooms(array))
    }

    @Test
    fun minimumRequiredRooms_2() {
        val array = arrayOf(Pair(30,75), Pair(0,50), Pair(60,150), Pair(40,70))
        assertEquals(3, minimumRequiredRooms(array))
    }
}