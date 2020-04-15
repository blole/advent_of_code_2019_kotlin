import java.io.ByteArrayInputStream
import java.io.File

class IntcodeComputer(val ram: MutableList<Int>, val io: Kattio) {
    constructor(program: String, io: Kattio = Kattio()) : this(program.split(',').map(String::toInt).toMutableList(), io)
    var pc = 0

    fun step(): IntcodeComputer {
        object {
            private inner class Arg(val i: Int) {
                val isImmediate = when ((ram[pc]/10.toBigInteger().pow(1+i).toInt())%10) {
                    0 -> false
                    1 -> true
                    else -> throw IllegalArgumentException("asd")
                }
                fun get(): Int  = if (isImmediate) ram[pc+i] else ram[ram[pc+i]]
                fun set(v: Int) {
                    if (isImmediate)
                        throw IllegalArgumentException("can't write to immediate mode parameters")
                    else
                        ram[ram[pc+i]] = v
                }
            }
            val op = ram[pc]%100
            var a get() = Arg(1).get(); set(it) { Arg(1).set(it) }
            var b get() = Arg(2).get(); set(it) { Arg(2).set(it) }
            var c get() = Arg(3).get(); set(it) { Arg(3).set(it) }
        }.apply {
            when (op) {
                1 -> { c=a+b; pc+=4 }
                2 -> { c=a*b; pc+=4 }
                3 -> { a=io.int(); pc+=2 }
                4 -> { io.println(a); io.flush(); pc+=2 }
                5 -> { if (a!=0) pc=b else pc+=3 }
                6 -> { if (a==0) pc=b else pc+=3 }
                7 -> { c = if (a<b)  1 else 0; pc+=4 }
                8 -> { c = if (a==b) 1 else 0; pc+=4 }
                else -> throw IllegalArgumentException("Unknown opcode $op")
            }
        }
        return this
    }

    fun run(): IntcodeComputer {
        while (ram[pc] != 99)
            step()
        return this
    }

    fun call(noun: Int, verb: Int): Int {
        ram[1] = noun
        ram[2] = verb
        run()
        return ram[0]
    }
    fun call(nounAndVerb: Int) = call(nounAndVerb/100, nounAndVerb%100)
}

fun string(s: String) = Kattio(ByteArrayInputStream(s.toByteArray()))
fun file(i: Int) = Kattio(File("src/test/resources/in/%02d.txt".format(i)).inputStream())
