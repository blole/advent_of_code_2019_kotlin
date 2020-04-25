
fun gcd(x: Int, y: Int) = x.toBigInteger().abs().gcd(y.toBigInteger().abs()).toInt()
fun Pos.reducedFraction() = Pos(x / gcd(x,y), y / gcd(x,y))

class Day10(io: Kattio) {
    val asteroids = io.words()
        .withIndex()
        .flatMap { (y, line) ->
            line.withIndex()
                .filter { (_, c) -> c == '#' }
                .map    { (x, _) -> Pos(x, y) }
                .asSequence()
        }.toList()

    fun a(): Int? = asteroids
        .map { origin ->
            asteroids
                .filter { it != origin }
                .map    { (it-origin).reducedFraction() }
                .toSet()
                .size
        }.max()
}
