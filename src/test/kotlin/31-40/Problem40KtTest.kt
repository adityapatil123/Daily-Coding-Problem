import `31-40`.getNonDuplicateNumber
import org.junit.Test

import org.junit.Assert.*

class Problem40KtTest {

    @Test
    fun getNonDuplicateNumber_1() {
        assertEquals(1, getNonDuplicateNumber(arrayOf(6, 1, 3, 3, 3, 6, 6)))
    }

    @Test
    fun getNonDuplicateNumber_2() {
        assertEquals(19, getNonDuplicateNumber(arrayOf(13, 19, 13, 13)))
    }
}