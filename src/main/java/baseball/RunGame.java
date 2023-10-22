package baseball;

import model.BaseballNumber;
import view.InputView;
import view.OutputView;

public class RunGame {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BaseballGame baseballGame = new BaseballGame();

    public void playBaseballGame() {
        BaseballGame.computerNumber = BaseballNumber.makeBaseballNumber();
        BaseballGame.finish = true;
        outputView.gameStart();

        while (BaseballGame.finish) { // 게임이 끝날때까지 반복
            outputView.gameNumer();
            BaseballGame.myNumber = inputView.inputBaseBall();
            baseballGame.gameResult();
        }

        outputView.gameFinish();
        outputView.restartGame();

        int restart = inputView.inputRetryNumber();
        if (baseballGame.gameRestart(restart)) playBaseballGame();
    }
}
