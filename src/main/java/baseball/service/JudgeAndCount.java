package baseball.service;

import baseball.domain.GameNumber;
import baseball.utility.GenerateRandomNumber;
import baseball.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class JudgeAndCount {
    private static final String STRIKE_MESSAGE = "스트라이크 ";
    private static final String BALL_MESSAGE = "볼 ";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final int GAME_RULE_NUMBER_LENGTH = 3;
    private static final int GAME_RULE_GOAL_STRIKE_COUNT = 3;
    private static final int INIT_COUNT = 0;
    private int strikeCount;
    private int ballCount;
    GenerateRandomNumber generateRandomNumber = new GenerateRandomNumber();
    OutputView outputView = new OutputView();

    public boolean proceedComputerToDo(GameNumber gameNumber) {
        List<Integer> playerNumbers = gameNumber.getUserNumbers();
        List<Integer> computerNumbers = gameNumber.getComputerNumbers();

        compareNumbers(playerNumbers, computerNumbers);

        return isCorrectAnswer();
    }

    public void compareNumbers(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        initCount();
        checkCount(playerNumbers, computerNumbers);
        totalCount(); //카운트 메세지 출력
    }

    private void initCount() {
        strikeCount = INIT_COUNT;
        ballCount = INIT_COUNT;
    }

    private void checkCount(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        for (int i = 0; i < GAME_RULE_NUMBER_LENGTH; i++) {
            countStrike(computerNumbers.get(i), playerNumbers.get(i));
            countBall(computerNumbers, playerNumbers.get(i), i);
        }
    }

    private void countStrike(int computerNumber, int playerNumber) {
        if (computerNumber == playerNumber) {
            strikeCount++;
        }
    }

    private void countBall(List<Integer> computerNumbers, int playerNumber, int numberIndex) {
        if (computerNumbers.get(numberIndex) != playerNumber && computerNumbers.contains(playerNumber)) {
            ballCount++;
        }
    }

    public void totalCount() {
        String totalCount = "";

        totalCount += getBallCount();
        totalCount += getStrikeCount();
        totalCount += getNotingCount();

        outputView.countResultMsg(totalCount);
    }

    private String getBallCount() {
        if (ballCount > 0) {
            return ballCount + BALL_MESSAGE;
        }
        return "";
    }

    private String getStrikeCount() {
        if (strikeCount > 0) {
            return strikeCount + STRIKE_MESSAGE;
        }

        return "";
    }

    private String getNotingCount() {
        if (ballCount == 0 && strikeCount == 0) {
            return NOTHING_MESSAGE;
        }

        return "";
    }

    public boolean isCorrectAnswer() {
        return strikeCount == GAME_RULE_GOAL_STRIKE_COUNT;
    }
}