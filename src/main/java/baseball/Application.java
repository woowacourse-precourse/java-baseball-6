package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.printStartMessage();

        Game game = Game.getInstance(outputView, inputView);
        game.run();
    }
}
