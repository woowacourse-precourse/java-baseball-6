package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computer {
    private List<Integer> number;
    private Map<String, Integer> result;

    public void makeNumberSet() {
        number = new ArrayList<>();
        while (number.size() < Constants.gameInputLength) {
            makeRandomNumber();
        }
    }

    private void makeRandomNumber() {
        int candidateNum = Randoms.pickNumberInRange(Constants.gameNumberRangeMin, Constants.gameNumberRangeMax);
        if (!number.contains(candidateNum)) {
            number.add(candidateNum);
        }
    }

    private void initResultValue() {
        result = new HashMap<String, Integer>() {{
            put(Constants.ballState, 0);
            put(Constants.strikeState, 0);
        }};
    }

    public String makeResult(List<Integer> predictedNumbers) {
        initResultValue();
        for (int i = 0; i < predictedNumbers.size(); i++) {
            checkValueResult(predictedNumbers.get(i), number.get(i));
        }
        return makeResultState();
    }

    private String makeResultState() {
        if (checkNoBall() && checkNoStrike()) {
            return Constants.nothingState;
        }
        if (checkNoStrike()) {
            return makeSubResultState(Constants.ballState);
        }
        if (checkNoBall()) {
            return makeSubResultState(Constants.strikeState);
        }
        return makeSubResultState(Constants.ballState) + " " + makeSubResultState(Constants.strikeState);
    }

    private String makeSubResultState(String state) {
        return result.get(state) + state;
    }

    private Boolean checkNoStrike() {
        return result.get(Constants.strikeState) == 0;
    }

    private Boolean checkNoBall() {
        return result.get(Constants.ballState) == 0;
    }

    private void checkValueResult(int predictedValue, int realValue) {
        if (predictedValue == realValue) {
            result.put(Constants.strikeState, result.get(Constants.strikeState) + 1);
        } else if (number.contains(predictedValue)) {
            result.put(Constants.ballState, result.get(Constants.ballState) + 1);
        }
    }

}
