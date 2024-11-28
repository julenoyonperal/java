package dev.lpa;

import dev.lpa.game.GameConsole;
import dev.lpa.game.ShooterGame;

public class Main {

    public static void main(String[] args) {

        var console = new GameConsole<>(new ShooterGame("The Shootout Game"));

        int playerIndex = console.addPlayer();
        console.playGame(playerIndex);
    }
}
