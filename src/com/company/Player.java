package com.company;

import java.util.*;

public class Player {
    private GamePlayer gamePlayer;
    private Stack<GameResult> gameResults = new Stack<>();

    public Player() {
    }

    public Player(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public GameResult playDices(Dice dice, Dice dice2) {
        int result = dice.rollDice() + dice2.rollDice();

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int predictedNumber;
        if (gamePlayer.equals(GamePlayer.USER)) {
            do {
                System.out.println("\nyour guess:");
                predictedNumber = scanner.nextInt();
            } while (predictedNumber < 2 || predictedNumber > 12);
        } else {
            System.out.println("computer guess...");
            predictedNumber = random.nextInt(2, 7);
            System.out.println(predictedNumber);
        }

        GameResult gameResult = new GameResult(predictedNumber, result, gamePlayer);

        System.out.println("dices rolling...");
        System.out.println(dice);
        System.out.println(dice2);

        gameResults.push(gameResult);
        return gameResult;
    }
}
