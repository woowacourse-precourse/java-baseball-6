package baseball.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameService {

    private static final int COMPUTER_NUMBER_SIZE = 3;
    private static final int COMPUTER_NUMBER_START_RANGE = 1;
    private static final int COMPUTER_NUMBER_END_RANGE = 9;
    private static final int BALL_COUNT_INITIAL_VALUE = 0;
    private static final int STRIKE_COUNT_INITIAL_VALUE = 0;
    private static final int BALL_COUNT_INCREASE_VALUE = 1;
    private static final int STRIKE_COUNT_INCREASE_VALUE = 1;

    public List<Integer> createComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < COMPUTER_NUMBER_SIZE) {
            addNumber(computerNumber);
        }
        return computerNumber;
    }

    private void addNumber(List<Integer> computerNumber) {
        int number = pickNumberInRange(COMPUTER_NUMBER_START_RANGE, COMPUTER_NUMBER_END_RANGE);
        if (!computerNumber.contains(number)) {
            computerNumber.add(number);
        }
    }

    public String getCompareResult(List<Integer> computerNumber, List<Integer> userNumber) {
        Map<String, Integer> ballAndStrikeCount = getBallAndStrikeCount(computerNumber, userNumber);
        return getResultMessage(ballAndStrikeCount);
    }

    private Map<String, Integer> getBallAndStrikeCount(List<Integer> computerNumber, List<Integer> userNumber) {
        Map<String, Integer> ballAndStrikeCount = ballAndStrikeCountInitialization();
        ballAndStrikeCount(computerNumber, userNumber, ballAndStrikeCount);
        return ballAndStrikeCount;
    }

    private Map<String, Integer> ballAndStrikeCountInitialization() {
        Map<String, Integer> ballAndStrikeCount = new HashMap<>();
        ballAndStrikeCount.put("ballCount", BALL_COUNT_INITIAL_VALUE);
        ballAndStrikeCount.put("strikeCount", STRIKE_COUNT_INITIAL_VALUE);
        return ballAndStrikeCount;
    }

    private void ballAndStrikeCount(List<Integer> computerNumber, List<Integer> userNumber,
                                    Map<String, Integer> ballAndStrikeCount) {
        for (int i = 0; i < userNumber.size(); i++) {
            if (isBall(computerNumber, userNumber, i)) {
                increaseBallCount(ballAndStrikeCount);
            }
            if (isStrike(computerNumber, userNumber, i)) {
                increaseStrikeCount(ballAndStrikeCount);
            }
        }
    }

    private boolean isBall(List<Integer> computerNumber, List<Integer> userNumber, int index) {
        return (computerNumber.contains(userNumber.get(index))) && (computerNumber.get(index) != userNumber.get(index));
    }

    private void increaseBallCount(Map<String, Integer> ballAndStrikeCount) {
        ballAndStrikeCount.put("ballCount", ballAndStrikeCount.get("ballCount") + BALL_COUNT_INCREASE_VALUE);
    }

    private boolean isStrike(List<Integer> computerNumber, List<Integer> userNumber, int index) {
        return computerNumber.get(index) == userNumber.get(index);
    }

    private void increaseStrikeCount(Map<String, Integer> ballAndStrikeCount) {
        ballAndStrikeCount.put("strikeCount", ballAndStrikeCount.get("strikeCount") + STRIKE_COUNT_INCREASE_VALUE);
    }

    private String getResultMessage(Map<String, Integer> ballAndStrikeCount) {
        StringBuilder resultMessage = new StringBuilder();
        getNothingMessage(ballAndStrikeCount, resultMessage);
        getBallMessage(ballAndStrikeCount, resultMessage);
        getStrikeMessage(ballAndStrikeCount, resultMessage);
        getBallAndStrikeMessage(ballAndStrikeCount, resultMessage);
        return resultMessage.toString();
    }

    private void getNothingMessage(Map<String, Integer> ballAndStrikeCount, StringBuilder resultMessage) {
        if (isNothing(ballAndStrikeCount)) {
            resultMessage.append("낫싱");
        }
    }

    private boolean isNothing(Map<String, Integer> ballAndStrikeCount) {
        return (ballAndStrikeCount.get("ballCount") == BALL_COUNT_INITIAL_VALUE) &&
                (ballAndStrikeCount.get("strikeCount") == STRIKE_COUNT_INITIAL_VALUE);
    }

    private void getBallMessage(Map<String, Integer> ballAndStrikeCount, StringBuilder resultMessage) {
        if (isOnlyBall(ballAndStrikeCount)) {
            resultMessage.append(ballAndStrikeCount.get("ballCount") + "볼");
        }
    }

    private boolean isOnlyBall(Map<String, Integer> ballAndStrikeCount) {
        return (ballAndStrikeCount.get("ballCount") != BALL_COUNT_INITIAL_VALUE) &&
                (ballAndStrikeCount.get("strikeCount") == STRIKE_COUNT_INITIAL_VALUE);
    }

    private void getStrikeMessage(Map<String, Integer> ballAndStrikeCount, StringBuilder resultMessage) {
        if (isOnlyStrike(ballAndStrikeCount)) {
            resultMessage.append(ballAndStrikeCount.get("strikeCount") + "스트라이크");
        }
    }

    private boolean isOnlyStrike(Map<String, Integer> ballAndStrikeCount) {
        return (ballAndStrikeCount.get("ballCount") == BALL_COUNT_INITIAL_VALUE) &&
                (ballAndStrikeCount.get("strikeCount") != STRIKE_COUNT_INITIAL_VALUE);
    }

    private void getBallAndStrikeMessage(Map<String, Integer> ballAndStrikeCount, StringBuilder resultMessage) {
        if (isBallAndStrike(ballAndStrikeCount)) {
            resultMessage.append(ballAndStrikeCount.get("ballCount"))
                    .append("볼 ")
                    .append(ballAndStrikeCount.get("strikeCount"))
                    .append("스트라이크");
        }
    }

    private boolean isBallAndStrike(Map<String, Integer> ballAndStrikeCount) {
        return (ballAndStrikeCount.get("ballCount") != BALL_COUNT_INITIAL_VALUE) &&
                (ballAndStrikeCount.get("strikeCount") != STRIKE_COUNT_INITIAL_VALUE);
    }
}
