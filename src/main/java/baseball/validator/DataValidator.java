package baseball.validator;

import static baseball.Constants.DIGIT_NUMBER;

import java.util.HashSet;
import java.util.Set;

public class DataValidator {
    public void validatePlayerAnswer(int[] playerAnswerArray) {
        if (playerAnswerArray.length != DIGIT_NUMBER || isContainZero(playerAnswerArray)
                || isDuplicate(playerAnswerArray)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isContainZero(int[] playerAnswerArray) {
        for(int i : playerAnswerArray){
            if(i==0){
                throw new IllegalArgumentException();
            }
        }
        return false;
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

}
