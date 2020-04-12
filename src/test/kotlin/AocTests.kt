import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.*

class AocTests {
    fun String.toKattio() = Kattio(ByteArrayInputStream(toByteArray()))
    inline fun <reified T: AocClass> create(io: Kattio): T = T::class.constructors.first().call(io)
    inline fun <reified T: AocClass> create(input: String): T = create<T>(input.toKattio())
    inline fun <reified T: AocClass> create(): T {
        val file = File("src/test/resources/in/${T::class.simpleName?.drop(3)}.txt")
        return create(Kattio(file.inputStream()))
    }

    @Test
    fun `day01`() {
        assertEquals(2,       create<Day01>("12").a())
        assertEquals(2,       create<Day01>("14").a())
        assertEquals(654,     create<Day01>("1969").a())
        assertEquals(33583,   create<Day01>("100756").a())
        assertEquals(3320226, create<Day01>().a())

        assertEquals(2,       create<Day01>("14").b())
        assertEquals(966,     create<Day01>("1969").b())
        assertEquals(50346,   create<Day01>("100756").b())
        assertEquals(4977473, create<Day01>().b())
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

    @Test
    fun `test day03a`() {
        assertEquals(6, Day03(Kattio(ByteArrayInputStream("R8,U5,L5,D3\nU7,R6,D4,L4".toByteArray()))).a())
        assertEquals(159, Day03(Kattio(ByteArrayInputStream("R75,D30,R83,U83,L12,D49,R71,U7,L72\nU62,R66,U55,R34,D71,R55,D58,R83".toByteArray()))).a())
        assertEquals(135, Day03(Kattio(ByteArrayInputStream("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51\nU98,R91,D20,R16,D67,R40,U7,R15,U6,R7".toByteArray()))).a())

        val io = Kattio(File("src/test/resources/in/03.txt").inputStream())
        assertEquals(5319, Day03(io).a())
    }

    @Test
    fun `test day03b`() {
        assertEquals(30, Day03(Kattio(ByteArrayInputStream("R8,U5,L5,D3\nU7,R6,D4,L4".toByteArray()))).b())
        assertEquals(610, Day03(Kattio(ByteArrayInputStream("R75,D30,R83,U83,L12,D49,R71,U7,L72\nU62,R66,U55,R34,D71,R55,D58,R83".toByteArray()))).b())
        assertEquals(410, Day03(Kattio(ByteArrayInputStream("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51\nU98,R91,D20,R16,D67,R40,U7,R15,U6,R7".toByteArray()))).b())

        val io = Kattio(File("src/test/resources/in/03.txt").inputStream())
        assertEquals(122514, Day03(io).b())
    }
}
