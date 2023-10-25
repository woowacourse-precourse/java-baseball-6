package baseball.service;

import baseball.utility.RandomNumberGeneration;
import baseball.view.OutputView;

import java.util.List;

public class JudgeAndCount {
    private static final int GAME_RULE_NUMBER_LENGTH = 3;
    private static final int GAME_RULE_GOAL_STRIKE_COUNT = 3;
    private static final int INIT_COUNT = 0;
    private static final String STRIKE_MSG = "스트라이크 ";
    private static final String BALL_MSG = "볼 ";
    private static final String NOTHING_MSG = "낫싱";
    private int strikeCount;
    private int ballCount;
    OutputView outputView = new OutputView();

    public void compareNumbers(List<Integer> userNumbers, List<Integer> computerNumbers) {
        initCount();
        checkCount(userNumbers, computerNumbers);
        totalCount();
    }
    private void initCount() {
        strikeCount = INIT_COUNT;
        ballCount = INIT_COUNT;
    }
    private void checkCount(List<Integer> userNumbers, List<Integer> computerNumbers) {
        for (int i = 0; i < GAME_RULE_NUMBER_LENGTH; i++) {
            countStrike(computerNumbers.get(i), userNumbers.get(i));
            countBall(computerNumbers, userNumbers.get(i), i);
        }
    }
    private void countStrike(int computerNumber, int userNumber) {
        if (computerNumber == userNumber) {
            strikeCount++;
        }
    }
    private void countBall(List<Integer> computerNumbers, int userNumber, int numberIndex) {
        if (computerNumbers.get(numberIndex) != userNumber && computerNumbers.contains(userNumber)) {
            ballCount++;
        }
    }
    public void totalCount() {
        String totalCount = "";

        if (ballCount > 0) {
            totalCount += ballCount + BALL_MSG;
        }
        if (strikeCount > 0) {
            totalCount += strikeCount + STRIKE_MSG;
        }
        if (ballCount == 0 && strikeCount == 0) {
            totalCount += NOTHING_MSG;
        }
        outputView.countResultMsg(totalCount);
    }

    public boolean isCorrectAnswer() {
        return strikeCount == GAME_RULE_GOAL_STRIKE_COUNT;
    }
}