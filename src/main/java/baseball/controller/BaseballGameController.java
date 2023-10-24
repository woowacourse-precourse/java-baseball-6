package baseball.controller;

import baseball.model.BaseballGameUtils;
import baseball.model.ComputerNumber;
import baseball.model.Score;
import baseball.model.UserNumber;
import baseball.view.BaseballGameView;

public class BaseballGameController {
    private BaseballGameView baseballGameView;
    private BaseballGameUtils baseballGameUtils;

    public BaseballGameController() {
        baseballGameView = new BaseballGameView();
        baseballGameUtils = new BaseballGameUtils();
    }

    public boolean startGame() {
        ComputerNumber computerNumber = new ComputerNumber();
        UserNumber userNumber;
        Score result;
        boolean isAnswer = false;

        while (!isAnswer) {
            userNumber = baseballGameView.readUserNumber();
            result = baseballGameUtils.checkScore(computerNumber.getNumber(), userNumber.getNumber());
            isAnswer = baseballGameView.showResult(result);
        }

        return baseballGameView.showRestart();
    }

}
