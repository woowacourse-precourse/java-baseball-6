package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {

        OutputView.start();

        boolean exitFlag = false;

        while(!exitFlag) {

            Game game = new Game();
            game.play();

            OutputView.askExit();
            exitFlag = InputView.askExit();
        }

        OutputView.exit();
    }
}
