package baseball.baseballV1.view;

import baseball.baseballV1.util.Constants;

public class OutputView {
    public static void displayGameEnd() {
        System.out.println(Constants.GAME_END_MESSAGE);
    }

    public static void displaySentence(String result) {
        System.out.println(result);
    }
}
