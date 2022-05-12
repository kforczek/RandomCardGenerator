abstract class UserInterface(val gen: Generator) {

    /* Displays the interface */
    abstract fun show(version: String)

    /* Closes the view and disposes of the UI */
    abstract fun dispose()

    /* Collects info from the user
    and returns an InputData object */
    abstract fun inputParam(): InputData

    /* Waits for user action */
    abstract fun waitForAction()

    /* Prints a card passed as argument */
    abstract fun printCard(card: Card)

    /* Prints a message to the user */
    abstract fun printMessage(info: String)

    /* Informs the Generator about the
    * next card choice */
    protected fun callNextCard() {
        gen.callNextCard()
    }

    /* Informs the Generator about the
    * reset choice */
    protected fun callReset() {
        gen.callReset()
    }
}