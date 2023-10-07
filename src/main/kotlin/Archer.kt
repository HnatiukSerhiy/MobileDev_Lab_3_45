import kotlin.math.abs

class Archer(health: Int, armor: Int) : Character(health, armor) {
    private val minDamage: Int = 5
    private val maxDamage: Int = 7
    private val minDefendPoints = 2
    private val maxDefendPoints = 4

    override fun makeAttackTurnCore(target: Character) {
        val damage = getAttackDamage(minDamage, maxDamage)
        target.takeDamage(damage)
    }

    override fun makeDefendTurnCore() {
        val defendPoints = getDefendPoints(minDefendPoints, maxDefendPoints)
        this.armor = defendPoints
    }

    override fun takeDamage(amount: Int) {
        if (this.previousTurnType == TurnType.Attack) {
            this.health -= amount
            return
        }

        if (this.previousTurnType == TurnType.Defend) {
            this.health -= abs(this.armor - amount)
            return
        }
    }

}