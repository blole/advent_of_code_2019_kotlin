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

    @Test
    fun `test IntcodeComputer`() {
        assertEquals(70, IntcodeComputer("1,9,10,3,2,3,11,0,99,30,40,50").step().ram[3])
        assertEquals(3500, IntcodeComputer("1,9,10,3,2,3,11,0,99,30,40,50").run().ram[0])
        assertEquals(2, IntcodeComputer("1,0,0,0,99").run().ram[0])
        assertEquals(6, IntcodeComputer("2,3,0,3,99").run().ram[3])
        assertEquals(9801, IntcodeComputer("2,4,4,5,99,0").run().ram[5])
        assertEquals(30, IntcodeComputer("1,1,1,4,99,5,6,0,99").run().ram[0])
    }

    @Test
    fun `test day02a`() {
        val io = Kattio(File("src/test/resources/in/02.txt").inputStream())
        assertEquals(3516593, Day02(io).a())
    }

    @Test
    fun `test day02b`() {
        val io = Kattio(File("src/test/resources/in/02.txt").inputStream())
        assertEquals(7749, Day02(io).b())
    }
}
