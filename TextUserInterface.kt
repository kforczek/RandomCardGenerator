class TextUserInterface(gen: Generator) : UserInterface(gen) {
    override fun show(version: String) {
        println("Random Card Generator $version")
    }

    override fun dispose() {}

    override fun inputParam(): InputData {
        println("\nList of card values:")
        outputVals<CardValue>()
        println("Select minimum and maximum card value of the deck.")
        var minInt = inputInt("Minimum: ", 1, CardValue.values().size+1)-1
        var maxInt = inputInt("Maximum: ", 1, CardValue.values().size+1)-1

        while (maxInt < minInt) {
            println("Maximum value cannot be less than minimum. Try again.")
            minInt = inputInt("Minimum: ", 1, CardValue.values().size+1)-1
            maxInt = inputInt("Maximum: ", 1, CardValue.values().size+1)-1
        }

        println("\nType 'y' or 'n' to select/unselect suits for the deck.")
        val cardSuitSet = inputSetSelect<CardSuit>()

        println("\nType 'y' or 'n' to select/unselect colors for the deck.")
        val cardColorSet = inputSetSelect<CardColor>()

        return InputData(CardValue.values()[minInt], CardValue.values()[maxInt],
                         cardSuitSet, cardColorSet)
    }

    override fun waitForAction() {
        while (true) {
            println("\nChoose an action:")
            println("1 - next card")
            println("2 - reset deck")
            println("3 - exit")

            val choice = inputInt("> ", 1, 3)
            when (choice) {
                1 -> callNextCard()
                2 -> callReset()
                3 -> return
            }
        }
    }

    override fun printCard(card: Card) {
        val colName = capitalize(card.color.name)
        val valName = capitalize(card.value.name)
        val suitName = capitalize(card.suit.name)
        println("Card: $colName $valName of $suitName")
    }

    override fun printMessage(info: String) {
        println(info)
    }

    @Suppress("SameParameterValue")
    private fun inputInt(prompt: String, min: Int, max: Int): Int {
        print(prompt)
        var input = readln().toIntOrNull()

        while (input == null || input < min || input > max) {
            print("That is not a correct value, try again.")
            print(prompt)
            input = readln().toIntOrNull()
        }

        return input
    }

    private fun inputChoice(prompt: String): Boolean {
        print(prompt)
        var input = readln().lowercase()

        while (input != "y" && input != "n") {
            print("That is not a correct value, try again.")
            print(prompt)
            input = readln().lowercase()
        }

        return input == "y"
    }

    private inline fun <reified E: Enum<E>> inputSetSelect(): Set<E> {
        val set = mutableSetOf<E>()
        for (elem in enumValues<E>()) {
            if (inputChoice("${capitalize(elem.name)} (y/n): "))
                set.add(elem)
        }

        return set
    }

    private inline fun <reified E: Enum<E>> outputVals() {
        for (value in enumValues<E>()) {
            println("${value.ordinal+1} - ${capitalize(value.name)}")
        }
    }

    private fun capitalize(str: String): String {
        return str[0].uppercase()+str.substring(1).lowercase()
    }
}