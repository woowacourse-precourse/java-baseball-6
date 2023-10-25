package baseball.view;

import baseball.game.Hint;
import baseball.utils.GameMessage;

public class OutputView {
    public static void printStartGame() {
        System.out.print(GameMessage.GAME_START_MESSAGE);
    }

    public static void printHint(Hint hint) {
        int ball = hint.getBall();
        int strike = hint.getStrike();

        if (ball != 0 && strike == 0) {
            System.out.printf(GameMessage.BALL_HINT_MESSAGE, ball);
        } else if (ball == 0 && strike != 0) {
            System.out.printf(GameMessage.STRIKE_HINT_MESSAGE, strike);
        } else if (ball != 0 && strike != 0) {
            System.out.printf(GameMessage.BALL_AND_STRIKE_HINT_MESSAGE, ball, strike);
        } else if (ball == 0 && strike == 0) {
            System.out.print(GameMessage.NOTHING_HINT_MESSAGE);
        }
    }

    public static void printEndGame() {
        System.out.print(GameMessage.GAME_END_MESSAGE);
    }
}
