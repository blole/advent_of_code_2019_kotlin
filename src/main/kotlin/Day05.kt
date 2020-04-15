import java.io.ByteArrayInputStream
import java.io.File

class Day05(io: Kattio) {
    val program = io.word()

    fun a() = IntcodeComputer(program, string("5")).run()
}

fun main() {
    val comp = IntcodeComputer(file(5).word(), string("1"))
    repeat(100) {
        println(comp.ram)
        comp.run()
        println(comp.pc)
    }
}
