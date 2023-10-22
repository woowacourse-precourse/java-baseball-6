package baseball;

import view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputView inputView = new InputView();
        boolean restart;
        do {
            Game baseballGame = BaseballGame.getInstance();
            baseballGame.start();
            restart = inputView.restart();

        } while (restart);

    }
}
