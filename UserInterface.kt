interface UserInterface {

    /* Displays the interface */
    fun show()

    /* Closes the view and disposes of the UI */
    fun dispose()

    /* Collects info from the user
    and returns an InputData object */
    fun inputParam(): InputData

    /* Prints a card passed as argument */
    fun printCard(card: Card)
}