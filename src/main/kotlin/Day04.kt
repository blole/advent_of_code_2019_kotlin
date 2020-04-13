class Day04(io: Kattio) {
    val range = io.word().split('-').map(String::toInt).let { (a,b) -> a..b }

    fun hasDouble(i: Int): Boolean =
        i>10 && (
            i%10 == (i/10)%10 ||
            hasDouble(i/10)
        )
    fun hasSoloDouble(i: Int): Boolean =
        i>10 && (
            (i/10)%10 != i%10 &&
            (i/10)%10 == (i/100)%10 &&
            (i/10)%10 != (i/1000)%10 ||
            hasSoloDouble(i/10)
        )
    fun next(i: Int): Int = if (i%10 == 9) next(i/10).let { it*10 + it%10 } else i+1
    fun IntRange.filterIncreasing() = generateSequence(0) { next(it) }.takeWhile { it <= last }.dropWhile { it < first }


    fun a(): Int = range.filterIncreasing().count(::hasDouble)
    fun b(): Int = range.filterIncreasing().count { hasSoloDouble(it*10) }
}
