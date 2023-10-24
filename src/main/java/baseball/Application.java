package baseball;

import baseball.controller.NumberBaseballGameController;
import baseball.domain.service.NumberBaseBallGame;
import baseball.domain.service.NumberBaseballScoreEvaluator;
import baseball.domain.util.BaseballRandomNumberGenerator;
import baseball.view.NumberBaseballGameInputView;
import baseball.view.NumberBaseballGameOutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new NumberBaseballGameController(
                new NumberBaseballGameInputView(),
                new NumberBaseballGameOutputView(),
                new NumberBaseBallGame(
                        new BaseballRandomNumberGenerator(),
                        new NumberBaseballScoreEvaluator()
                )
        ).playGame();
    }
}
