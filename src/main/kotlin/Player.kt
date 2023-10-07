class Player(var name: String, var character: Character) {
    fun makeAttackTurn(target: Character) {
        this.character.makeAttackTurn(target)
    }

    fun makeDefendTurn() {
        this.character.makeDefendTurn()
    }
}