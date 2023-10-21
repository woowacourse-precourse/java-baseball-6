package baseball.controller;

import baseball.BaseballGameMessage;
import baseball.service.BaseBallService;
import baseball.view.BaseballInputView;
import baseball.view.BaseballOutputView;

import java.util.List;

public class BaseBallGameController {
    private final BaseBallService baseBallService;
    private final BaseballInputView baseballInputView;
    private final BaseballOutputView baseballOutputView;

    public BaseBallGameController() {
        baseBallService = new BaseBallService();
        baseballInputView = new BaseballInputView();
        baseballOutputView = new BaseballOutputView();
    }

    public void startGame() {
        while (true) {
            playSingleGame();
            if (!decideNextAction()) {
                break;
            }
        }
    }

    private void playSingleGame() {
        baseballOutputView.printMessage(BaseballGameMessage.START_GAME);

        List<Integer> targetNumber = baseBallService.generateRandomNumbers();

        while (true) {
            baseballOutputView.printUserInputMessage(BaseballGameMessage.REQUEST_USER_INPUT);
            List<Integer> userInput = baseballInputView.userGuessInput();
            String gameResult = baseBallService.getGameResult(targetNumber, userInput).toString();
            baseballOutputView.printGameResult(gameResult);

            if (gameResult.equals("3스트라이크")) {
                System.out.println(BaseballGameMessage.GAME_OVER);
                break;
            }
        }
    }

    private boolean decideNextAction() {
        baseballOutputView.printMessage(BaseballGameMessage.QUIT_OR_START_GAME);
        int userInput = baseballInputView.userProgressInput();
        return userInput == 1;
    }
}