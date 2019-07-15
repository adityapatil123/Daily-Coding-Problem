import org.junit.Test

import org.junit.Assert.*

class Problem17KtTest {

    @Test
    fun getMaximumLengthOfPath_1() {
        val str = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
        assertEquals(32, getMaxLengthFromGivenStringTree(str))
    }

    @Test
    fun getMaximumLengthOfPath_2() {
        val str = "file\n\tfile1\n\t\tfile2\n\t\t\tfile4\n\tfile3"
        assertEquals(0, getMaxLengthFromGivenStringTree(str))
    }

    @Test
    fun getMaximumLengthOfPath_3() {
        assertEquals(0, getMaxLengthFromGivenStringTree(""))
    }
}