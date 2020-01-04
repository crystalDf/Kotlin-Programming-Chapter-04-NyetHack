import kotlin.math.pow

fun main(args: Array<String>) {

    val name = "Star"
    var healthPoints = 89
    var isBlessed = true
    val isImmortal = false
    val auraVisible = (isBlessed && healthPoints > 50) || isImmortal
    val karma = (Math.random().pow((110 - healthPoints) / 100.0) * 20).toInt()
    val auraColor = if (auraVisible) {
        when (karma) {
            in 0..5 -> "RED"
            in 6..10 -> "ORANGE"
            in 11..15 -> "PURPLE"
            in 16..20 -> "GREEN"
            else -> "NONE"
        }
    } else "NONE"

    val healthStatus = when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75.. 89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }

    println("(Aura: $auraColor) " +
            "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")

    val statusFormatString = "(HP)(A) -> H"
    val result: StringBuilder = StringBuilder("")

    for (i in statusFormatString.indices) {

        val replacement = when (statusFormatString[i]) {
            'B' -> "Blessed: ${if (isBlessed) "YES" else "NO"}"
            'A' -> "Aura: $auraColor"
            'H' -> if (((i + 1) < statusFormatString.length) && (statusFormatString[i + 1] == 'P')) {
                "HP: $healthPoints"
            } else {
                "$name $healthStatus"
            }
            'P' -> ""
            else -> {
                statusFormatString[i].toString()
            }
        }

        result.append(replacement)
    }

    print(result)
}
