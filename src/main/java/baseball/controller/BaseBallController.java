package baseball.controller;

import baseball.domain.BaseBallGame;
import baseball.domain.GameResult;
import baseball.domain.UserNum;
import baseball.valid.InputValidation;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseBallController {

    private BaseBallGame baseBallGame = new BaseBallGame();
    private UserNum userNum = new UserNum();

    public void run() {
        OutputView.printGameStart();
        String restartNum = "1";

        while (restartNum.equals("1")) {
            String inputUserNum = InputView.inputUserNum();
            InputValidation.validateInputNum(inputUserNum);
            List<Integer> integers = userNum.buildUserNum(inputUserNum);
            GameResult gameResult = baseBallGame.compareNumList(integers);
            OutputView.printBallAndStrike(gameResult.getBall(), gameResult.getStrike());
            if (baseBallGame.isStrikeMax(gameResult.getStrike())) {
                OutputView.printGameEnd();
                restartNum = InputView.inputRestart();
                if(restartNum.equals("1")){
                    baseBallGame.buildNewComputerList();
                }
            }
        }
    }
}
