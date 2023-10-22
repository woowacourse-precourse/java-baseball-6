package baseball.service;

import baseball.view.OutputView;

import java.util.List;
import java.util.Objects;

public class BaseballGameCompareService {
    public void compareUserNumberAndRandomNumber(List<Integer> target1, List<Integer> target2) {
        OutputView outputView = new OutputView();
        int strikeCount = countStrike(target1, target2);
        int ballCount = countBall(target1, target2) - strikeCount;
        outputView.printGameResultBallAndStrike(ballCount, strikeCount);
        isThreeStrike(strikeCount, target2);
    }

    private int countStrike(List<Integer> target1, List<Integer> target2) {
        int strikeCount = 0;
        for (int i = 0; i < target1.size(); i++) {
            if (Objects.equals(target1.get(i), target2.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int countBall(List<Integer> target1, List<Integer> target2) {
        int ballCount = 0;
        for (int i = 0; i < target1.size(); i++) {
            if (target2.contains(target1.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private void isThreeStrike(int strikeCount, List<Integer> target2) {
        BaseballGameService baseballGameService = new BaseballGameService();
        if (strikeCount == 3) {
            baseballGameService.endBaseballGame();
        } else {
            baseballGameService.startBaseballGame(target2);
        }
    }
}
