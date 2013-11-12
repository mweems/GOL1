package com.mweems;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new GameOfLifeModule());
        GameOfLife gameOfLife = injector.getInstance(GameOfLife.class);
        gameOfLife.run();

    }
}
