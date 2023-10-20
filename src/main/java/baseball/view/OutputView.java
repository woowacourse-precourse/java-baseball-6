package baseball.view;

import baseball.util.Constants;

public class OutputView {
    public static void displayThreeStrikes() {
        System.out.println(Constants.GAME_END_MESSAGE);
    }

    public static void displaySentence(String result) {
        System.out.println(result);
    }
}
