package com.company;

import java.util.Stack;

public class GameResult {
    private GamePlayer gamePlayer;
    private int predicted;
    private int dice;
    private int result;

    public GameResult() {
    }

    public GameResult(int predicted, int dice, GamePlayer gamePlayer) {
        this.predicted = predicted;
        this.dice = dice;
        this.result = dice - Math.abs(dice - predicted) * 2;
        this.gamePlayer = gamePlayer;
    }

    public GamePlayer getGamePlayer() {
        return gamePlayer;
    }

    public void setGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public int getPredicted() {
        return predicted;
    }

    public void setPredicted(int predicted) {
        this.predicted = predicted;
    }

    public int getDice() {
        return dice;
    }

    public void setDice(int dice) {
        this.dice = dice;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "\n\nPredicted = " + predicted +
                "\nDice = " + dice +
                "\nResult = " + result
                ;
    }
}
