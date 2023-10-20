package baseball;

import baseball.controller.BaseballController;
import baseball.service.ScoreCalculator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballController controller = new BaseballController(new ScoreCalculator(),
                new InputView(), new OutputView());
        controller.run();
    }
}
