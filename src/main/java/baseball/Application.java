package baseball;

import baseball.application.BaseballGameService;
import baseball.application.BaseballGeneratorFactory;
import baseball.domain.BaseBallReferee;
import baseball.presentation.BaseballGameController;

public class Application {
    public static void main(String[] args) {
        BaseballGameService baseballGameService = new BaseballGameService(new BaseBallReferee(), new BaseballGeneratorFactory());
        BaseballGameController baseballGameController = new BaseballGameController(baseballGameService);

        baseballGameController.startGame();
    }
}
