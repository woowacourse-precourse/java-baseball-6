package baseball.view;

import baseball.model.BallCount;
import baseball.model.Result;
import baseball.util.ConsoleMessage;
import java.util.List;

public class OutputView {
    public void printGameStart() {
        System.out.println(ConsoleMessage.OUTPUT_GAME_START.getMessage());
    }

    public void printComputerNumber(List<Integer> computerNumber) {
        System.out.println(computerNumber);
    }

    public void printGameResult(Result result) {
        int strike = result.getResultByBallCount(BallCount.STRIKE);
        int ball = result.getResultByBallCount(BallCount.BALL);
        int nothing = result.getResultByBallCount(BallCount.NOTHING);

        System.out.println(result.getResult());
    }

}
