class Generator() {
    private val version = "1.0"
    private lateinit var ui: UserInterface
    private lateinit var deck: Deck

    fun run() {
        if (!this::ui.isInitialized)
            throw IllegalStateException("No UserInterface set.")

        ui.show(version)
        deck = Deck(ui.inputParam())
        ui.waitForAction()
        ui.dispose()
    }

    fun setUI(ui: UserInterface) {
        this.ui = ui
    }

    fun callNextCard() {
        if (!deck.isEmpty())
            ui.printCard(deck.nextCard())
        else
            ui.printMessage("There are no cards in the deck.")
    }

    fun callReset() {
        deck = Deck(ui.inputParam())
    }
}