/* Represents user's choice of the deck parameters.
*  The deck will contain cards with values from
*  cardValMin (inclusive) to cardValMax (inclusive),
*  in suits defined by cardSuits and in colors defined
*  by cardColors. */
data class InputData(val cardValMin: CardValue = CardValue.values().first(),
                     val cardValMax: CardValue = CardValue.values().last(),
                     val cardSuits: Set<CardSuit> = CardSuit.values().toSet(),
                     val cardColors: Set<CardColor> = CardColor.values().toSet())