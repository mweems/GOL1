package com.mweems;

import com.google.inject.AbstractModule;

public class GameOfLifeModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(GameOfLife.class).to(DefaultGameOfLife.class);
        bind(Grid.class).to(DefaultGrid.class);
        bind(Parser.class).to(DefaultParser.class);
        bind(CLI.class).to(DefaultCLI.class);

    }

}
