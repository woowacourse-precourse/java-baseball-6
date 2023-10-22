package baseball;

import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();

        outputView.printStartMessage();

        Game game = Game.getInstance(outputView);
        game.run();
    }
}
