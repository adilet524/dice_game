package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> gameResults = new Stack<>();
        List<Integer> gameResults1 = new ArrayList<>();
        List<Integer> gameResults2 = new ArrayList<>();

        Dice dice = new Dice();
        Dice dice2 = new Dice();

        Player user = new Player(GamePlayer.USER);
        Player computer = new Player(GamePlayer.COMPUTER);

        for (int i = 0; i < 3; i++) {
            GameResult gameResult = user.playDices(dice, dice2);
            GameResult gameResult1 = computer.playDices(dice, dice2);

            System.out.println("User: " + gameResult.getResult());
            System.out.println("Computer: " + gameResult1.getResult());

            if (gameResult.getResult() > gameResult1.getResult()) {
                int users = gameResult.getResult() - gameResult1.getResult();
                System.out.println("User is ahead by " + users + " points!");
            } else {
                int computers = gameResult1.getResult() - gameResult.getResult();
                System.out.println("Computer is ahead by " + computers + " points!");

                gameResults.add(gameResult.getPredicted());
                gameResults.add(gameResult1.getPredicted());
                gameResults1.add(gameResult.getDice());
                gameResults1.add(gameResult1.getDice());
                gameResults2.add(gameResult.getResult());
                gameResults2.add(gameResult1.getResult());
            }
        }

        int counter = 0;
        int j = 1;
        for (int p = 0; p < 3; p++) {
            System.out.printf("""
                                   | Predicted   %d  | Predicted  %d
                            - %d -  | Dice        %d  | Dice       %d
                                   | Result      %d  | Result     %d
                            -------+----------------+----------------
                            """, gameResults.get(counter), gameResults.get(j), p,
                    gameResults1.get(counter), gameResults1.get(j),
                    gameResults2.get(counter), gameResults2.get(j)
            );
            counter += 2;
            j += 2;
        }
    }
}
