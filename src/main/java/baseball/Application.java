package baseball;

import baseball.core.Referee;
import baseball.core.ThreeStrikeEndGameRule;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Referee referee = new Referee(new ThreeStrikeEndGameRule());
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        new GameManager(referee, inputView, outputView).play();
    }
}
