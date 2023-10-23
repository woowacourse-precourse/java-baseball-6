package baseball.printer;

import static baseball.resources.GameConst.ZERO;


import baseball.resources.GameMessage;

public class Printer {
    public void printStartMessage() {
        System.out.println(GameMessage.GAME_START);
    }

    public void printInputMessage() {
        System.out.print(GameMessage.INPUT_NUMBER);
    }

    public void printBallCount(int strike, int ball) {
        if (strike == ZERO && ball == ZERO) {
            System.out.println(GameMessage.NOTHING);
        } else if (strike == ZERO && ball > ZERO) {
            System.out.printf(GameMessage.ONLY_BALL, ball);
        } else if (strike > ZERO && ball == ZERO) {
            System.out.printf(GameMessage.ONLY_STRIKE, strike);
        } else if (strike > ZERO && ball > ZERO){
            System.out.printf(GameMessage.BALL_AND_STRIKE, ball, strike);
        }
    }

    public void printCorrectMessage() {
        System.out.println(GameMessage.CORRECT_MESSAGE);
    }

    public void printAskRestart() {
        System.out.println(GameMessage.ASK_RESTART);
    }
}
