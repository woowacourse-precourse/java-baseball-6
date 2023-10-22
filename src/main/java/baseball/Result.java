package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Result {
    private final int GAME_OVER = 3;
    private GameOver gameOver;
    Result() {
        gameOver = new GameOver();
    }

    public void print(int strike, int ball, int nothing) {
        if (ball > 0) {
            printBall(ball);
        }
        if (strike > 0) {
            printStrike(strike);
        } else if (nothing > 0) {
            printNothing();
        }
        System.out.println();
    }

    void printBall(int ball) {
        System.out.print(ball + "볼 ");
    }

    void printStrike(int strike) {
        if (strike == GAME_OVER) {
           gameOver.print();
        } else {
            System.out.print(strike + "스트라이크 ");
        }
    }

    void printNothing() {
        System.out.print("낫싱");
    }
}
