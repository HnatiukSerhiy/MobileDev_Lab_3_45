enum class Status {
    None,
    Win,
    Lose
}

class GameStatus(var isGameEnded: Boolean, var description: String, var status: Status) {

    companion object {
        fun win(description: String): GameStatus {
            return GameStatus(true, description, Status.Win)
        }

       fun lose(description: String): GameStatus {
           return GameStatus(true, description, Status.Win)
       }

       fun none(): GameStatus {
           return GameStatus(false, "", Status.None)
       }
   }
}

class GameStatusHandler {
    fun getStatus(player: Player, enemy: Enemy): GameStatus {
        if (enemy.character.health <= 0)
            return GameStatus.win("You won!")

        if (player.character.health <= 0)
            return GameStatus.lose("You lost!")

        return GameStatus.none()
    }
}