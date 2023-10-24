package baseball.controller;

import baseball.BaseballGameMessage;
import baseball.service.BaseBallService;
import baseball.view.BaseballInputView;
import baseball.view.BaseballOutputView;

import camp.nextstep.edu.missionutils.Console;
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
        baseballOutputView.printMessage(BaseballGameMessage.START_GAME);
        while (true) {
            playSingleGame();
            if (!decideNextAction()) {
                break;
            }
        }
    }

    private void playSingleGame() {

        List<Integer> targetNumber = baseBallService.generateRandomNumbers();

        while (true) {
            baseballOutputView.printUserInputMessage(BaseballGameMessage.REQUEST_USER_INPUT);
            List<Integer> userInput = baseballInputView.userGuessInput(Console.readLine());
            String gameResult = baseBallService.getGameResult(targetNumber, userInput).toString();
            baseballOutputView.printGameResult(gameResult);

            if (BaseballGameMessage.isThreeStrikes(gameResult)) {
                System.out.println(BaseballGameMessage.GAME_OVER);
                break;
            }
        }
    }

    private boolean decideNextAction() {
        baseballOutputView.printMessage(BaseballGameMessage.QUIT_OR_START_GAME);
        int userInput = baseballInputView.userProgressInput(Console.readLine());
        return userInput == 1;
    }
}