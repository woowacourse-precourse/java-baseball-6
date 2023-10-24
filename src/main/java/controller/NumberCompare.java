package controller;

import model.PlayerNumber;
import model.RandomComputerNumber;
import view.OutputView;

import java.util.ArrayList;
import java.util.Objects;

public class NumberCompare {
    private final ArrayList<Integer> playerNumber;
    private final ArrayList<Integer> computerNumber;
    private int strike;
    private int ball;
    private boolean isGameEnded;

    public NumberCompare(ArrayList<Integer> playerNumber, ArrayList<Integer> computerNumber) {
        this.playerNumber = playerNumber;
        this.computerNumber = computerNumber;
    }

    public void compare() {
        strike = 0;
        ball = 0;
        isGameEnded = false;
        System.out.println(playerNumber);
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(playerNumber.get(i), computerNumber.get(i))) {
                strike++;
            } else if (computerNumber.contains(playerNumber.get(i))) {
                ball++;
            }
        }
        if (strike == 3) {
            isGameEnded = true;
        }
        printResult();
    }

    public void printResult() {
        if (strike == 0 && ball == 0) {
            OutputView.printNothingMessage();
        } else if (strike == 0) {
            OutputView.printBallMessage(ball);
        } else if (ball == 0) {
            OutputView.printStrikeMessage(strike);
        } else {
            OutputView.printStrikeAndBallMessage(strike, ball);
        }
    }

    public boolean isGameEnded() {
        return isGameEnded;
    }

}
