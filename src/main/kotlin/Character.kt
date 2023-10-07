abstract class Character(var health: Int, var armor: Int) {
    var previousTurnType: TurnType = TurnType.None

    fun makeAttackTurn(target: Character) {
        makeAttackTurnCore(target)
        previousTurnType = TurnType.Attack
    }

    fun makeDefendTurn() {
        makeDefendTurnCore()
        previousTurnType = TurnType.Defend
    }

    abstract fun takeDamage(amount: Int)

    protected abstract fun makeAttackTurnCore(target: Character)

    protected abstract fun makeDefendTurnCore()

    protected fun getAttackDamage(minAttack: Int, maxAttack: Int): Int {
        return (minAttack..maxAttack).random()
    }

    protected fun getDefendPoints(minDefend: Int, maxDefend: Int): Int {
        return (minDefend..maxDefend).random()
    }
}
