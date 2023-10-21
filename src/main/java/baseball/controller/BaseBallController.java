package baseball.controller;

import static baseball.consts.NumberConst.GAME_RESTART_NUMBER;

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
        String restartNum = GAME_RESTART_NUMBER;

        while (restartNum.equals(GAME_RESTART_NUMBER)) {
            String inputUserNum = InputView.inputUserNum();
            InputValidation.validateInputNum(inputUserNum);

            List<Integer> integers = userNum.buildUserNum(inputUserNum);
            GameResult gameResult = baseBallGame.compareNumList(integers);

            OutputView.printBallAndStrike(gameResult.getBall(), gameResult.getStrike());
            restartNum = checkMaxStrike(restartNum, gameResult);
        }
    }

    private String checkMaxStrike(String restartNum, GameResult gameResult) {
        if (baseBallGame.isStrikeMax(gameResult.getStrike())) {
            OutputView.printGameEnd();
            restartNum = InputView.inputRestart();
            InputValidation.validateRestartNum(restartNum);
            checkRestartNum(restartNum);
        }
        return restartNum;
    }

    private void checkRestartNum(String restartNum) {
        if (restartNum.equals(GAME_RESTART_NUMBER)) {
            baseBallGame.buildNewComputerList();
        }
    }
}
