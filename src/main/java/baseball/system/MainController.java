package baseball.system;

import baseball.domain.BaseballGame;
import baseball.domain.strategy.RandomBallNumbersGenerateStrategy;
import baseball.view.input.MainInputView;
import baseball.view.output.MainOutputView;

public class MainController {

    public void play() {
        do {
            MainOutputView.printGameStartScript();

            BaseballGame baseballGame = BaseballGame.newGame(new RandomBallNumbersGenerateStrategy());
            baseballGame.play();

            MainOutputView.printGameEndScript();
            MainOutputView.printShouldStartNewGameScript();
        } while (MainInputView.readShouldStartNewGame());
    }

}
