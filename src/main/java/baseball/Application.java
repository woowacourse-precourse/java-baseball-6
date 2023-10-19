package baseball;

import baseball.view.AskView;
import baseball.view.StartView;

public class Application {

    private static final int PLAY_NUMBER_DIGIT = 3;

    public static void main(String[] args) {
        StartView.welcome();
        AskView.askNumberInput();
    }
}
