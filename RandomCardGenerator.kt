fun main(args: Array<String>)
{
    if (args.contains("-nogui"))
    {
        val gen = Generator()
        val ui = TextUserInterface(gen)
        gen.setUI(ui)
        gen.run()
    }
    else
    {
        println("Graphical UI not implemented yet." +
                " Please use the text UI by running with \"-nogui\".")
    }
}