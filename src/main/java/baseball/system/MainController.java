package baseball.system;

import baseball.domain.BaseballGame;
import baseball.domain.strategy.RandomUniqueBallNumbersGenerateStrategy;
import baseball.view.input.MainInputView;
import baseball.view.output.MainOutputView;

public class MainController {

    private MainController() {
    }

    public static MainController instance() {
        return new MainController();
    }

    public void play() {
        MainOutputView.printGameStartScript();
        do {
            BaseballGame baseballGame = BaseballGame.newGame(RandomUniqueBallNumbersGenerateStrategy.instance());
            baseballGame.play();

            MainOutputView.printGameEndScript();
            MainOutputView.printShouldStartNewGameScript();
        } while (MainInputView.readShouldStartNewGame());
    }

}
