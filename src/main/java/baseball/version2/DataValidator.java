package baseball.version2;


import static baseball.version2.Constants.Phrases.ANSWER_ERROR_PHRASES;
import static baseball.version2.Constants.Phrases.DECISION_ERROR_PHRASES;
import static baseball.version2.Constants.Value.CONTINUE_NUMBER;
import static baseball.version2.Constants.Value.STOP_NUMBER;
import static java.lang.Integer.parseInt;

import java.util.HashSet;
import java.util.Set;

public class DataValidator {

    public static int[] validateIsNumberAndSize(String[] answerStringArray, int[] answerArray) {
        int answerOrder = 0;
        try {
            for (String answerValue : answerStringArray) {
                answerArray[answerOrder++] = parseInt(answerValue);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ANSWER_ERROR_PHRASES);
        } catch (ArrayIndexOutOfBoundsException a) {
            throw new IllegalArgumentException(ANSWER_ERROR_PHRASES);
        }

        return answerArray;
    }

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

        if (playerAnswerArray.length != playerValueSet.size()) {
            return true;
        }

        return false;
    }


    public int validateDecisionIsNumber(String playerDecision) {
        int decision;
        try {
            decision = Integer.parseInt(playerDecision);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return decision;
    }

    public void validateDecision(int decision) {
        if (decision != CONTINUE_NUMBER && decision != STOP_NUMBER) {
            throw new IllegalArgumentException(DECISION_ERROR_PHRASES);
        }
    }


}
