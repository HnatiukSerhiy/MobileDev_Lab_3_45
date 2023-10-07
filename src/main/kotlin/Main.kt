fun main(args: Array<String>) {
    print("Enter your name: ")
    val name = readln().split(' ').first()

    print("Enter your character type (possible values: Swordsman, Archer): ")
    val characterTypeInput = readln().split(' ').first()
    val characterType = enumValueOf<CharacterType>(characterTypeInput)

    val provider = PlayerCharactersProvider()
    val character = provider.getCharacter(characterType)

    val player = Player(name, character)
    val dragon = Dragon(150, 10)
    val enemy = Enemy("Dragon", dragon)

    val gameHandler = GameStatusHandler()

    while (true) {
        print("Enter your turn (possible values: Attack, Defend): ")
        val turnInput = readln().split(' ').first()
        val turn = enumValueOf<TurnType>(turnInput)

        if (turn == TurnType.Attack)
            player.makeAttackTurn(enemy.character)

        if (turn == TurnType.Defend)
            player.makeDefendTurn()

        var status = gameHandler.getStatus(player, enemy)
        if (status.isGameEnded) {
            println(status.description)
            break
        }

        enemy.makeTurn(player.character)

        status = gameHandler.getStatus(player, enemy)
        if (status.isGameEnded) {
            println(status.description)
            break
        }

        println("${player.name} health: {${player.character.health}}, armor: ${player.character.armor}");
        println("${enemy.name} health: {${enemy.character.health}}, armor: ${enemy.character.armor}");
    }
}
