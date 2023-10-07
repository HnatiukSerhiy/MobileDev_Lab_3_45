public class Enemy(var name: String, var character: Character) {
    fun makeTurn(target: Character) {
        val turn = getTurn()
        if (turn == TurnType.Attack) {
            character.makeAttackTurn(target)
            return
        }

        if (turn == TurnType.Defend) {
            character.makeDefendTurn()
            return
        }
    }

    private fun getTurn(): TurnType {
        val randomNumber = (1..2).random()
        return TurnType.entries.toTypedArray()[randomNumber]
    }
}