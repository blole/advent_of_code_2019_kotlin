
class IntcodeComputer(val ram: MutableList<Int>) {
    constructor(program: String) : this(program.split(',').map(String::toInt).toMutableList())
    var pc = 0

    fun step(): IntcodeComputer {
        val op = ram[pc]
        when (op) {
            1 -> { val (a,b,c) = ram.subList(pc+1,pc+4); pc+=4; ram[c] = ram[a]+ram[b] }
            2 -> { val (a,b,c) = ram.subList(pc+1,pc+4); pc+=4; ram[c] = ram[a]*ram[b] }
            else -> throw IllegalArgumentException("Unknown opcode $op")
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
