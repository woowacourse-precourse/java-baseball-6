package baseball;

import controller.BaseballGame;
import model.RandomNumber;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(new InputView(), new OutputView(), new RandomNumber());
        baseballGame.start();
    }
}
