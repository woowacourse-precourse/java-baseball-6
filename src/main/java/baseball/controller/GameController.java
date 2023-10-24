package baseball.controller;

import static baseball.resources.GameConst.*;

import baseball.domain.ComputerNum;
import baseball.domain.UserNum;
import baseball.service.BallCountService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BallCountService ballCountService;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.ballCountService = new BallCountService();
    }

    public void gameStart() {
        outputView.startGame();
        ComputerNum answerNum = new ComputerNum();

        boolean gameOver;

        while(continueGame(answerNum)) {
            UserNum userNum = new UserNum(inputView.inputUserNumber());
            gameOver = checkResult(answerNum, userNum);

            if (gameOver) {
                outputView.gameOver();
                Integer wantRestart = inputView.askRestart();
                answerNum = restartGame(wantRestart);
            }
        }
    }

    private static boolean continueGame(ComputerNum comNum) {
        return comNum != null;
    }

    private boolean checkResult(ComputerNum comNum, UserNum userNum) {
        int strike = ballCountService.countStrike(userNum.getNum(), comNum.getNum());
        int ball = ballCountService.countBall(userNum.getNum(), comNum.getNum());
        outputView.printBallCount(strike, ball);
        return strike == ALL_STRIKE;
    }

    private ComputerNum restartGame(Integer wantRestart) {
        if (wantRestart == WANT_RESTART) {
            return new ComputerNum();
        } else if (wantRestart == WANT_EXIT) {
            return null;
        }

        throw new IllegalArgumentException();
    }
}
