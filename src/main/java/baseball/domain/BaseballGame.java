package baseball.domain;

import baseball.view.View;

import java.util.List;

public class BaseballGame {

    private final BaseballNumbers baseballNumbers;
    private boolean isDone;

    public BaseballGame(BaseballNumbers baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public void start() {
        while (!isDone) {
            PlayerNumbers playerNumbers = View.inputPlayerNumbers();
            Result result = this.checkHitsResult(baseballNumbers.getNumbers(), playerNumbers.getNumbers());
            View.PrintResult(result);

            if (result.isThreeStrike()) isDone = true;
        }
    }

    // TODO: 객체 간의 대화로 해결할 것
    private Result checkHitsResult(List<Integer> baseballNumbers, List<Integer> playerNumbers) {
        int strike = 0, ball = 0;
        for (int i = 0; i < baseballNumbers.size(); i++) {
            if (playerNumbers.contains(baseballNumbers.get(i))) ball++;
            if (baseballNumbers.get(i).equals(playerNumbers.get(i))) strike++;
        }
        ball -= strike;

        return Result.of(strike, ball);
    }
}
