package baseball.controller;

import baseball.model.Baseball;
import baseball.model.Result;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.printGameStart();
        repeatGame();
    }

    public void repeatGame() {
        int decisionNum = 1;
        do {
            game();
            outputView.printGameFinish();
            decisionNum = inputView.getDecisionNum();
        } while (decisionNum != 2);

    }

    public void game() {
        Baseball baseball = new Baseball();
        Result result = new Result();
        List<Integer> computerNum;
        List<Integer> userNum;

        baseball.makeBaseball();

        computerNum = baseball.getBallNum();

        while (true) {
            userNum = inputView.getGameNum();
            result.makeResult(computerNum, userNum);

            if (result.getStrike() == 3) {
                break;
            }

            gameResult(result);
        }
    }

    public void gameResult(Result result) {
        if (result.getStrike() == 0 && result.getBall() == 0) {
            outputView.printNothing();
        } else {
            outputView.printBallStrike(result);
        }
    }

}
