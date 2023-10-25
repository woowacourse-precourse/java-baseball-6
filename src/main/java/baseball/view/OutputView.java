package baseball.view;

import static baseball.resources.GameConst.ZERO;

import baseball.resources.GameMessage;

public class OutputView {

    public void startGame() {
        System.out.println(GameMessage.GAME_START);
    }

    public void printBallCount(int strike, int ball) {
        if (strike == ZERO && ball == ZERO) {
            System.out.println(GameMessage.NOTHING);
        } else if (strike > ZERO && ball > ZERO) {
            System.out.printf(GameMessage.BALL_AND_STRIKE, ball, strike);
        } else if (strike > ZERO) {
            System.out.printf(GameMessage.ONLY_STRIKE, strike);
        } else if (ball > ZERO) {
            System.out.printf(GameMessage.ONLY_BALL, ball);
        }
    }

    public void gameOver() {
        System.out.println(GameMessage.CORRECT_MESSAGE);
    }
}
