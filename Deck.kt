import kotlin.random.Random

class Deck(deckParam: InputData) {

    private var cards = mutableListOf<Card>()

    init
    {
        // Initialize the deck with all cards it will contain

        for (cardVal in CardValue.values()) {
            if (cardVal < deckParam.cardValMin || cardVal > deckParam.cardValMax)
                continue

            for (cardSuit in CardSuit.values()) {
                for (cardCol in CardColor.values()) {
                    cards.add(Card(cardVal, cardSuit, cardCol))
                }
            }
        }
    }

    fun nextCard(): Card
    {
        val card = cards[Random.nextInt(cards.size)]
        cards.remove(card)
        return card
    }

    fun isEmpty(): Boolean
    {
        return cards.isEmpty()
    }
}