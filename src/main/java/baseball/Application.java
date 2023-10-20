package baseball;

import baseball.view.InputView;

public class Application {
    public static void main(String[] args) {
        new GameManager(new InputView()).play();
    }
}
