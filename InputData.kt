/* Represents user's choice of the deck parameters.
*  The deck will contain cards with values from
*  cardValMin (inclusive) to cardValMax (inclusive),
*  in suits defined by cardSuits and in colors defined
*  by cardColors. */
data class InputData(val cardValMin: CardValue = CardValue.ACE,
                     val cardValMax: CardValue = CardValue.JOKER,
                     val cardSuits: Set<CardSuit> = CardSuit.values().toSet(),
                     val cardColors: Set<CardColor> = CardColor.values().toSet())