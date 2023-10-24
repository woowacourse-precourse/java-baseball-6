package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> number;

    public void makeNumber() {
        number = new ArrayList<>();
        while (number.size() < Constants.gameInputLength) {
            int tmp = Randoms.pickNumberInRange(Constants.gameNumberRangeMin, Constants.gameNumberRangeMax);
            if (!number.contains(tmp)) {
                number.add(tmp);
            }
        }
    }

    public String makeResult(List<Integer> predictedNumbers) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < predictedNumbers.size(); i++) {
            if (accurateCheckPredictedValue(predictedNumbers.get(i), number.get(i))) {
                strike += 1;
            } else if (checkPredictedValue(predictedNumbers.get(i))) {
                ball += 1;
            }
        }
        return makeResultState(ball, strike);
    }

    private String makeResultState(int ball, int strike) {
        String result = "";
        if (ball != 0) {
            result += ball + Constants.ballState;
        }
        if (strike != 0) {
            if (ball != 0) {
                result += " ";
            }
            result += strike + Constants.strikeState;
        }
        if (result.length() == 0) {
            result = Constants.nothingState;
        }
        return result;
    }

    private Boolean accurateCheckPredictedValue(int predictedValue, int realValue) {
        if (predictedValue == realValue) {
            return true;
        } else {
            return false;
        }
    }

    private Boolean checkPredictedValue(int predictedValue) {
        if (number.contains(predictedValue)) {
            return true;
        } else {
            return false;
        }
    }

}
