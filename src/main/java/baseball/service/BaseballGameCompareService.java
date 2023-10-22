package baseball.service;

import baseball.view.OutputView;

import java.util.List;
import java.util.Objects;

public class BaseballGameCompareService {
    public void compareUserNumberAndRandomNumber(List<Integer> userNumberList, List<Integer> randomNumberList) {
        OutputView outputView = new OutputView();
        int strikeCount = countStrike(userNumberList, randomNumberList);
        int ballCount = countBall(userNumberList, randomNumberList) - strikeCount;
        outputView.printGameResultBallAndStrike(ballCount, strikeCount);
        isThreeStrike(strikeCount, randomNumberList);
    }

    private int countStrike(List<Integer> userNumberList, List<Integer> randomNumberList) {
        int strikeCount = 0;
        for (int i = 0; i < userNumberList.size(); i++) {
            if (Objects.equals(userNumberList.get(i), randomNumberList.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int countBall(List<Integer> userNumberList, List<Integer> randomNumberList) {
        int ballCount = 0;
        for (int i = 0; i < userNumberList.size(); i++) {
            if (randomNumberList.contains(userNumberList.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private void isThreeStrike(int strikeCount, List<Integer> randomNumberList) {
        BaseballGameService baseballGameService = new BaseballGameService();
        if (strikeCount == 3) {
            baseballGameService.endBaseballGame();
        } else {
            baseballGameService.startBaseballGame(randomNumberList);
        }
    }
}
