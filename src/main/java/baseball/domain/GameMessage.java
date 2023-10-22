package baseball.domain;

import static baseball.constant.Constant.*;

public class GameMessage {
    public void initGame() {
        System.out.println(INIT_GAME_MSG);
    }

    public void getInputNumber() {
        System.out.print(INPUT_NUMBERS_MSG);
    }

    public void endGame() {
        System.out.println(END_GAME_MSG);
    }

    public void getInputCommand() {
        System.out.println(INPUT_COMMAND_MSG);
    }

    public void showResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println(NOTHING);
            return;
        }
        if (strike > 0 && ball > 0) {
            System.out.println(ball + BALL + " " + strike + STRIKE);
        }
        if (strike > 0 && ball == 0) {
            System.out.println(strike + STRIKE);
        }
        if (strike == 0 && ball > 0) {
            System.out.println(ball + BALL);
        }
    }
}
