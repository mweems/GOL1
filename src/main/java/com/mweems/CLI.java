package com.mweems;

public class CLI implements UserInterface {

    private Prompter prompter;
    private StringParser stringParser;

    public CLI(Prompter prompter, StringParser stringParser) {
        this.prompter = prompter;
        this.stringParser = stringParser;
    }

    @Override
    public void run() {
        String userInput = prompter.promptForCellLocations();
        stringParser.parse(userInput);
    }
}
