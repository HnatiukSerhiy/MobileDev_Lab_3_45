class PlayerCharactersProvider() {
    private var characters: Map<CharacterType, Character>

    init {
        val swordsman = CharacterType.Swordsman to Swordsman(70, 10)
        val archer = CharacterType.Archer to  Archer(50, 5)

        characters = mapOf(swordsman, archer)
    }

    fun getCharacter(type: CharacterType ): Character {
        return characters.getOrDefault(type, CharacterType.Swordsman) as Character
    }
}