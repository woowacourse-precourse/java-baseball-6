package baseball;

import baseball.view.AskView;
import baseball.view.StartView;

public class Application {
    public static void main(String[] args) {
        StartView.welcome();
        AskView.askNumberInput();
    }
}
