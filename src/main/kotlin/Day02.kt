class Day02(io: Kattio) {
    val program = io.word()

    fun a() = IntcodeComputer(program).call(1202)
    fun b() = (0..9999).first { IntcodeComputer(program).call(it) == 19690720 }
}