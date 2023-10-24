package baseball.view;

import static baseball.model.constants.Phrase.BALL;
import static baseball.model.constants.Phrase.GAME_CLEAR_PHRASE;
import static baseball.model.constants.Phrase.GAME_START_PHRASE;
import static baseball.model.constants.Phrase.NOTHING;
import static baseball.model.constants.Phrase.STRIKE;

public class OutputView {
    public static void printGameStart() {
        System.out.println(GAME_START_PHRASE.getPhrase());
    }

    public static void printCount(int count) {
        System.out.print(count);
    }

    public static void printBall() {
        System.out.println(BALL.getPhrase());
    }

    public static void printBallStrike() {
        System.out.print(BALL.getPhrase() + " ");
    }

    public static void printStrike() {
        System.out.println(STRIKE.getPhrase());
    }

    public static void printNothing() {
        System.out.println(NOTHING.getPhrase());
    }

    public static void printGameClear() {
        System.out.println(GAME_CLEAR_PHRASE.getPhrase());
    }
}
