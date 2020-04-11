import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.*

class AocTests {
    @Test
    fun `test day01a`() {
        assertEquals(2,     Day01(Kattio(ByteArrayInputStream("12".toByteArray()))).a())
        assertEquals(2,     Day01(Kattio(ByteArrayInputStream("14".toByteArray()))).a())
        assertEquals(654,   Day01(Kattio(ByteArrayInputStream("1969".toByteArray()))).a())
        assertEquals(33583, Day01(Kattio(ByteArrayInputStream("100756".toByteArray()))).a())

        val io = Kattio(File("src/test/resources/in/01.txt").inputStream())
        assertEquals(3320226, Day01(io).a())
    }

    @Test
    fun `test day01b`() {
        assertEquals(2,     Day01(Kattio(ByteArrayInputStream("14".toByteArray()))).b())
        assertEquals(966,   Day01(Kattio(ByteArrayInputStream("1969".toByteArray()))).b())
        assertEquals(50346, Day01(Kattio(ByteArrayInputStream("100756".toByteArray()))).b())

        val io = Kattio(File("src/test/resources/in/01.txt").inputStream())
        assertEquals(4977473, Day01(io).b())
    }
}
