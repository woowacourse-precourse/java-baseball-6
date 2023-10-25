package baseball.domain;

import baseball.view.View;

public class BaseballGame {

    private final BaseballNumbers baseballNumbers;
    private boolean isDone;

    public BaseballGame(BaseballNumbers baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public void start() {
        while (!isDone) {
            PlayerNumbers playerNumbers = View.inputPlayerNumbers();
            Result result = playerNumbers.checkResult(baseballNumbers);
            View.printResult(result);

            if (result.isAllHit()) isDone = true;
        }
    }
}
