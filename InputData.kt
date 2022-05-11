data class InputData(val cardValMin: CardValue = CardValue.ACE,
                     val cardValMax: CardValue = CardValue.JOKER,
                     val cardSuits: Set<CardSuit> = CardSuit.values().toSet(),
                     val cardColors: Set<CardColor> = CardColor.values().toSet())