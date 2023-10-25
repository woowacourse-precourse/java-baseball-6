package controller;

import model.GameStrikeAndBall;
import view.OutputView;

import java.util.ArrayList;
import java.util.Objects;

public class NumberCompare {
    private final ArrayList<Integer> playerNumber;
    private final ArrayList<Integer> computerNumber;
    private boolean isGameEnded;


    public NumberCompare(ArrayList<Integer> playerNumber, ArrayList<Integer> computerNumber) {
        this.playerNumber = playerNumber;
        this.computerNumber = computerNumber;
    }

    public void compare() {
        GameStrikeAndBall gameResult = new GameStrikeAndBall();
        isGameEnded = false;
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(playerNumber.get(i), computerNumber.get(i))) {
                gameResult.strike++;
            } else if (computerNumber.contains(playerNumber.get(i))) {
                gameResult.ball++;
            }
        }
        if (gameResult.strike == 3) {
            isGameEnded = true;
        }
        printResult(gameResult.strike, gameResult.ball);
    }

    public void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            OutputView.printNothingMessage();
        } else if (strike == 0) {
            OutputView.printBallMessage(ball);
        } else if (ball == 0) {
            OutputView.printStrikeMessage(strike);
        } else if(strike > 0 && ball > 0){
            OutputView.printStrikeAndBallMessage(strike, ball);
        }
    }

    public boolean isGameEnded() {
        return isGameEnded;
    }

}
