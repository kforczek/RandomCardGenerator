import kotlin.random.Random

class Deck(deckParam: InputData) {

    private var cards = mutableListOf<Card>()

    init
    {
        // Initialize the deck with all cards it will contain

        for (cardVal in CardValue.values()) {
            if (cardVal < deckParam.cardValMin || cardVal > deckParam.cardValMax)
                continue

            for (cardSuit in deckParam.cardSuits) {
                for (cardCol in deckParam.cardColors) {
                    cards.add(Card(cardVal, cardSuit, cardCol))
                }
            }
        }
    }

    fun nextCard(): Card
    {
        if (this.isEmpty())
            throw IllegalStateException("There are no cards left in the deck.")

        val card = cards[Random.nextInt(cards.size)]
        cards.remove(card)
        return card
    }

    fun isEmpty(): Boolean
    {
        return cards.isEmpty()
    }
}