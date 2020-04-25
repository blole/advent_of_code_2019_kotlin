import kotlin.math.abs

data class Pos(val x: Int, val y: Int) {
    operator fun plus(o: Pos) = Pos(x+o.x, y+o.y)
    operator fun minus(o: Pos) = Pos(x-o.x, y-o.y)
    operator fun plus(o: Dir) = this+o.pos
    val manhattan get() = abs(x) + abs(y)
}

enum class Dir(val pos: Pos) {
    U(Pos( 0,-1)),
    R(Pos( 1, 0)),
    D(Pos( 0, 1)),
    L(Pos(-1, 0));
    val turnRight  get() = values()[(ordinal+1)%4]
    val turnAround get() = values()[(ordinal+2)%4]
    val turnLeft   get() = values()[(ordinal+3)%4]
}
