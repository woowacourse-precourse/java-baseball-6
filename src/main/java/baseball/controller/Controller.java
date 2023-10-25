package baseball.controller;

import baseball.domain.Baseball;
import baseball.domain.GameResult;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class Controller {
    private Baseball baseball;
    private boolean gameSituation;

    public Controller() {
        gameSituation = true;
    }

    public void run() {
        while (gameSituation) {
            init();
            playBaseballGame();
            gameSituation = InputView.restartGame();
        }
    }

    private void init() {
        baseball = new Baseball();
        OutputView.printStartGame();
    }

    private void playBaseballGame() {
        while (true) {
            OutputView.printInsertNumber();
            List<Integer> insertUserNumber = InputView.generateUserAnswer();
            GameResult resultBaseball = baseball.checkToStrikeAndBall(insertUserNumber);
            OutputView.printBaseBallResults(resultBaseball);
            if (resultBaseball.getStrikeCnt() == 3) {
                break;
            }
        }
    }

}
