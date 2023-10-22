package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> number;

    public void makeNumber() {
        number = new ArrayList<>();
        while (number.size() < 3) {
            int tmp = Randoms.pickNumberInRange(1, 9);
            if (!number.contains(tmp)) {
                number.add(tmp);
            }
        }
    }

    public String makeResult(List<Integer> predictedNumbers) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < 3; i++) {
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
            result += ball + "볼 ";
        }
        if (strike != 0) {
            result += strike + "스트라이크";
        }
        if (result.length() == 0) {
            result = "낫싱";
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
