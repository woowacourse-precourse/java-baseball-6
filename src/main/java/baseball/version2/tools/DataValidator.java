package baseball.version2.tools;


import static baseball.version2.constants.Phrases.ANSWER_ERROR_PHRASES;
import static baseball.version2.constants.Phrases.DECISION_ERROR_PHRASES;
import static baseball.version2.constants.Value.CONTINUE_NUMBER;
import static baseball.version2.constants.Value.STOP_NUMBER;

import java.util.HashSet;
import java.util.Set;

public class DataValidator {
    public void validatePlayerAnswer(int[] playerAnswerArray) {
        if (isContainZero(playerAnswerArray) || isDuplicate(playerAnswerArray)) {
            throw new IllegalArgumentException(ANSWER_ERROR_PHRASES);
        }
    }

    private boolean isContainZero(int[] playerAnswerArray) {
        for (int i : playerAnswerArray) {
            if (i == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean isDuplicate(int[] playerAnswerArray) {
        Set<Integer> playerValueSet = new HashSet<>();

        for (int i : playerAnswerArray) {
            playerValueSet.add(i);
        }
        return playerAnswerArray.length != playerValueSet.size();
    }

    public void validateDecision(int decision) {
        if (decision != CONTINUE_NUMBER && decision != STOP_NUMBER) {
            throw new IllegalArgumentException(DECISION_ERROR_PHRASES);
        }
    }
}
