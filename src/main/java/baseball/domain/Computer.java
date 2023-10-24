package baseball.domain;

import baseball.constant.GameConstants;
import baseball.util.InputValidator;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {

    private final List<Integer> result;
    private boolean isRetry;

    public Computer() {
        result = initResult();
    }

    public boolean isCorrect(List<Integer> playerNumbers) {
        return result.equals(playerNumbers);
    }

    public void retryOrEndGame(String flag) {
        validateFlag(flag);
        isRetry = flag.equals(GameConstants.RETRY);
    }

    public List<Integer> getResult() {
        return result;
    }

    public boolean isRetry() {
        return isRetry;
    }

    private static List<Integer> initResult() {
        Set<Integer> baseballNumberSet = new HashSet<>();
        while (baseballNumberSet.size() < GameConstants.BALL_COUNT) {
            baseballNumberSet.add(Randoms.pickNumberInRange(GameConstants.BALL_MIN_NUMBER, GameConstants.BALL_MAX_NUMBER));
        }

        return new ArrayList<>(baseballNumberSet);
    }

    private void validateFlag(String flag) {
        InputValidator.validateRetryOrEndFlag(flag);
    }
}
