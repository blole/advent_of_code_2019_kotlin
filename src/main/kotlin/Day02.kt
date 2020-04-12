class Day02(io: Kattio): AocClass {
    val program = io.word()

    override fun a() = IntcodeComputer(program).call(1202)
    override fun b() = (0..9999).first { IntcodeComputer(program).call(it) == 19690720 }
}