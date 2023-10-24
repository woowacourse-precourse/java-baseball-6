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
        while (isDone) {
            PlayerNumbers playerNumbers = View.inputPlayerNumbers();
            Result result = this.checkHitsResult(baseballNumbers.getNumbers(), playerNumbers.getNumbers());
            View.PrintResult(result);

            if (result.isThreeStrike()) isDone = true;
        }
    }

    private Result checkHitsResult(List<Integer> baseballNumbers, List<Integer> playerNumbers) {
        int[] hits = new int[2];

        for (int i = 0; i < baseballNumbers.size(); i++) {
            if (baseballNumbers.get(i).equals(playerNumbers.get(i))) {
                hits[1] += 1;
            } else if (playerNumbers.contains(baseballNumbers.get(i))) {
                hits[0] += 1;
            }
        }
        return Result.of(hits);
    }
}
