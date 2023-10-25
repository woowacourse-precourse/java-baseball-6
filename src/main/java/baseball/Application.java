package baseball;

import baseball.controller.BaseballGameController;
import baseball.domain.User;
import baseball.servcie.BaseballGameService;
import baseball.validation.BaseballGameValidation;
import baseball.view.BaseballGameView;


public class Application {

    public static void main(String[] args) {
        BaseballGameView baseballGameView = new BaseballGameView();
        BaseballGameService baseballGameService = new BaseballGameService(new User(), new BaseballGameValidation(), baseballGameView);
        BaseballGameController baseballGameController = new BaseballGameController(baseballGameService, baseballGameView);

        boolean gameContinue = true;

        while(gameContinue){
            baseballGameController.startGame();
            gameContinue = baseballGameController.checkRestartGame();
        }

    }
}
