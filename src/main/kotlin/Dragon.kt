import kotlin.math.abs

class Dragon(health: Int, armor: Int) : Character(health, armor) {
    private val minDamage = 3
    private val maxDamage = 8
    private val minDefendPoints = 2
    private val maxDefendPoints = 7

    override fun takeDamage(amount: Int) {
        if (this.previousTurnType == TurnType.Attack) {
            this.health -= amount / 2
            return
        }

        if (this.previousTurnType == TurnType.Defend) {
            this.health -= abs(this.armor - amount)
            return
        }
    }

    override fun makeAttackTurnCore(target: Character) {
        val damage = getAttackDamage(minDamage, maxDamage)
        target.takeDamage(damage)
    }

    override fun makeDefendTurnCore() {
        val points = getDefendPoints(minDefendPoints, maxDefendPoints)
        this.armor = points
    }

}