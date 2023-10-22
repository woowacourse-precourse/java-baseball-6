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
            int number = pickNumberInRange(COMPUTER_NUMBER_START_RANGE, COMPUTER_NUMBER_END_RANGE);
            if (!computerNumber.contains(number)) {
                computerNumber.add(number);
            }
        }
        return computerNumber;
    }

    public String getCompareResult(List<Integer> computerNumber, List<Integer> userNumber) {
        Map<String, Integer> ballAndStrikeCount = getBallAndStrikeCount(computerNumber, userNumber);
        return getResultMessage(ballAndStrikeCount);
    }

    private Map<String, Integer> getBallAndStrikeCount(List<Integer> computerNumber, List<Integer> userNumber) {
        Map<String, Integer> ballAndStrikeCount = new HashMap<>();
        ballAndStrikeCount.put("ballCount", BALL_COUNT_INITIAL_VALUE);
        ballAndStrikeCount.put("strikeCount", STRIKE_COUNT_INITIAL_VALUE);
        for (int i = 0; i < userNumber.size(); i++) {
            if (computerNumber.contains(userNumber.get(i)) && computerNumber.get(i) != userNumber.get(i)) {
                ballAndStrikeCount.put("ballCount", ballAndStrikeCount.get("ballCount") + BALL_COUNT_INCREASE_VALUE);
            }
            if (computerNumber.get(i) == userNumber.get(i)) {
                ballAndStrikeCount.put("strikeCount",
                        ballAndStrikeCount.get("strikeCount") + STRIKE_COUNT_INCREASE_VALUE);
            }
        }
        return ballAndStrikeCount;
    }

    private String getResultMessage(Map<String, Integer> ballAndStrikeCount) {
        String resultMessage = new String();
        if ((ballAndStrikeCount.get("ballCount") == BALL_COUNT_INITIAL_VALUE) &&
                (ballAndStrikeCount.get("strikeCount") == STRIKE_COUNT_INITIAL_VALUE)) {
            resultMessage = "낫싱";
        }
        if ((ballAndStrikeCount.get("ballCount") == BALL_COUNT_INITIAL_VALUE) &&
                (ballAndStrikeCount.get("strikeCount") != STRIKE_COUNT_INITIAL_VALUE)) {
            resultMessage = ballAndStrikeCount.get("strikeCount") + "스트라이크";
        }
        if ((ballAndStrikeCount.get("ballCount") != BALL_COUNT_INITIAL_VALUE) &&
                (ballAndStrikeCount.get("strikeCount") == STRIKE_COUNT_INITIAL_VALUE)) {
            resultMessage = ballAndStrikeCount.get("ballCount") + "볼";
        }
        if ((ballAndStrikeCount.get("ballCount") != BALL_COUNT_INITIAL_VALUE) &&
                (ballAndStrikeCount.get("strikeCount") != STRIKE_COUNT_INITIAL_VALUE)) {
            resultMessage = ballAndStrikeCount.get("ballCount") + "볼 " +
                    ballAndStrikeCount.get("strikeCount") + "스트라이크";
        }
        return resultMessage;
    }
}
