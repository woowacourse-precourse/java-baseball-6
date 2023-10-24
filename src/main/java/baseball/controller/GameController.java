package baseball.controller;

import baseball.domain.ComputerBalls;
import baseball.domain.PlayerBalls;
import baseball.domain.GameResult;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;


import baseball.constant.Constant;

public class GameController {

    public void play() {
        OutputView.printGameStartMessage();
        do {
            gameProcess();
        } while (InputView.gameRestart());
    }


    public void gameProcess() {
        ComputerBalls computerBalls = new ComputerBalls();
        GameResult playerResult = oneRound(computerBalls);
        while (!checkGameClear(playerResult)) {
            playerResult = oneRound(computerBalls);
        }
    }


    public GameResult oneRound(ComputerBalls computerBalls) {
        OutputView.printInputMessage();
        PlayerBalls playerBalls = new PlayerBalls(InputView.inputPlayerBalls());
        GameResult playerResult = GameService.judge(playerBalls.getBalls(), computerBalls.getBalls());
        OutputView.printPlayerResultMessage(playerResult);
        return playerResult;
    }

    public Boolean checkGameClear(GameResult playerResult) {
        if (playerResult.getStrike() == Constant.THREE_STRIKE_OUT) {
            OutputView.printGameEndMessage();
            return true;
        }
        return false;
    }

}