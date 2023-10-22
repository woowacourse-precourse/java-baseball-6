package baseball.version2;


import static baseball.version2.Constants.Value.*;
import static java.lang.Integer.parseInt;

import java.util.HashSet;
import java.util.Set;

public class DataValidator {

    public void validatePlayerAnswer(int[] playerAnswerArray) {
        if (isContainZero(playerAnswerArray) || isDuplicate(playerAnswerArray)) {
            throw new IllegalArgumentException();
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

    public static int[] validateIsNumberAndSize(String[] answerStringArray, int[] answerArray) {
        int answerOrder = 0;
        try {
            for (String answerValue : answerStringArray) {
                answerArray[answerOrder++] = parseInt(answerValue);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        } catch (ArrayIndexOutOfBoundsException a) {
            throw new IllegalArgumentException();
        }

        return answerArray;
    }

    private boolean isDuplicate(int[] playerAnswerArray) { // 중복 체크
        Set<Integer> playerValueSet = new HashSet<>();
        for (int i : playerAnswerArray) {
            playerValueSet.add(i);
        }

        if (playerAnswerArray.length != playerValueSet.size()) {
            return true;
        }

        return false;
    }

    public void validateDecision(int decision) {
        if (decision != CONTINUE_NUMBER && decision != STOP_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
