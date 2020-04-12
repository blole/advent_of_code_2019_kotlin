data class Wire(val dir: Dir, val length: Int)

fun List<Wire>.toPoints(): HashMap<Pos, Int> {
    var pos = Pos(0,0)
    var dist = 0
    val hashMap = HashMap<Pos, Int>()
    for (wire in this) {
        repeat(wire.length) {
            pos += wire.dir
            dist++
            hashMap.putIfAbsent(pos, dist)
        }
    }
    return hashMap
}

class Day03(io: Kattio): AocClass {
    val wires = io.words().map { wire ->
        wire.split(',').map { Wire(Dir.valueOf(it.take(1)), it.drop(1).toInt()) }
    }.toList()
    val pointsA = wires[0].toPoints()
    val pointsB = wires[1].toPoints()

    override fun a(): Int {
        return pointsA.keys.intersect(pointsB.keys).map { it.manhattan }.min()!!
    }

    override fun b(): Int {
        return pointsA.keys.intersect(pointsB.keys).map { pointsA[it]!!+pointsB[it]!! }.min()!!
    }
}
