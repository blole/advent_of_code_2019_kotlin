class Day01(io: Kattio) {
    val masses = io.ints().toList()

    fun fuel(mass: Int) = (mass/3-2).coerceAtLeast(0)

    fun a() = masses.sumBy(::fuel)

    fun b() = masses.sumBy { mass ->
        generateSequence(mass, ::fuel)
            .drop(1)
            .takeWhile { it>0 }
            .sum()
    }
}
