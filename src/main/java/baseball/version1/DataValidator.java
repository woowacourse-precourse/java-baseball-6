package baseball.version1;

import static baseball.version1.Constants.CONTINUE_NUMBER;
import static baseball.version1.Constants.DIGIT_NUMBER;
import static baseball.version1.Constants.STOP_NUMBER;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DataValidator {

    public void playerAnswerValidation(ArrayList<Integer> playerValue) { // 플레이어 입력값 검증
        if (playerValue.size() != DIGIT_NUMBER || playerValue.contains(0)
                || duplicationCheck(playerValue) == false) {
            throw new IllegalArgumentException();
        }
    }

    private boolean duplicationCheck(ArrayList<Integer> playerValue) { // 중복 체크
        Set<Integer> playerValueSet = new HashSet<>();
        for (int i : playerValue) {
            playerValueSet.add(i);
        }

        if (playerValue.size() != playerValueSet.size()) {
            return false;
        }

        return true;
    }

    public void continueDecisionValidate(int continueDecision) { // 게임 지속 여부 유효성 검증
        if (continueDecision != CONTINUE_NUMBER && continueDecision != STOP_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

}
