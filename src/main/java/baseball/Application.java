package baseball;

import baseball.core.Referee;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        new GameManager(new Referee(), new InputView(), new OutputView()).play();
    }
}
