import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.*

class AocTests {
    private fun string(s: String) = Kattio(ByteArrayInputStream(s.toByteArray()))
    private fun file(i: Int) = Kattio(File("src/test/resources/in/%02d.txt".format(i)).inputStream())

    @Test
    fun day01() {
        assertEquals(2,       Day01(string("12")).a())
        assertEquals(2,       Day01(string("14")).a())
        assertEquals(654,     Day01(string("1969")).a())
        assertEquals(33583,   Day01(string("100756")).a())
        assertEquals(3320226, Day01(file(1)).a())
        assertEquals(2,       Day01(string("14")).b())
        assertEquals(966,     Day01(string("1969")).b())
        assertEquals(50346,   Day01(string("100756")).b())
        assertEquals(4977473, Day01(file(1)).b())
    }

    @Test
    fun day02() {
        assertEquals(3516593, Day02(file(2)).a())
        assertEquals(7749,    Day02(file(2)).b())
    }

    @Test
    fun day03() {
        assertEquals(6,      Day03(string("R8,U5,L5,D3\nU7,R6,D4,L4")).a())
        assertEquals(159,    Day03(string("R75,D30,R83,U83,L12,D49,R71,U7,L72\nU62,R66,U55,R34,D71,R55,D58,R83")).a())
        assertEquals(135,    Day03(string("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51\nU98,R91,D20,R16,D67,R40,U7,R15,U6,R7")).a())
        assertEquals(5319,   Day03(file(3)).a())
        assertEquals(30,     Day03(string("R8,U5,L5,D3\nU7,R6,D4,L4")).b())
        assertEquals(610,    Day03(string("R75,D30,R83,U83,L12,D49,R71,U7,L72\nU62,R66,U55,R34,D71,R55,D58,R83")).b())
        assertEquals(410,    Day03(string("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51\nU98,R91,D20,R16,D67,R40,U7,R15,U6,R7")).b())
        assertEquals(122514, Day03(file(3)).b())
    }

    @Test
    fun day04() {
        assertEquals(1625, Day04(file(4)).a())
        assertEquals(1111, Day04(file(4)).b())
    }

    @Test
    fun day05() {
        assertEquals(9431221, Day05(file(5)).a())
    }

    @Test
    fun intcodeComputer() {
        assertEquals(70,   IntcodeComputer("1,9,10,3,2,3,11,0,99,30,40,50").step().ram[3])
        assertEquals(3500, IntcodeComputer("1,9,10,3,2,3,11,0,99,30,40,50").run().ram[0])
        assertEquals(2,    IntcodeComputer("1,0,0,0,99").run().ram[0])
        assertEquals(6,    IntcodeComputer("2,3,0,3,99").run().ram[3])
        assertEquals(9801, IntcodeComputer("2,4,4,5,99,0").run().ram[5])
        assertEquals(30,   IntcodeComputer("1,1,1,4,99,5,6,0,99").run().ram[0])
    }

    @Test
    fun intcodeComputerDay5() {
        assertEquals(55, IntcodeComputer("3,1", string("55")).step().ram[1])
        //assertEquals(55, IntcodeComputer("103,1", string("55")).step().ram[1])
        assertEquals(99, IntcodeComputer("1101,100,-1,4,0").step().ram[4])
        assertEquals(99, IntcodeComputer("1002,4,3,4,33").step().ram[4])
        assertEquals(1101, IntcodeComputer("3,0,1,0,6,6,1100", string("1")).step().step().ram[6])
        assertEquals(1, IntcodeComputer("3,0,4,0,99", string("1")).step().step().ram[0])
    }
}
