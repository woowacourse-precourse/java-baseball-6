package baseball.model;

import static baseball.common.Constant.MAX_STRIKE_NUMBER;
import static baseball.common.Constant.VALID_ANSWER_SIZE;

import baseball.common.AnswerState;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ComparisonResult {
    private final String result;
    private final boolean isCorrect;

    private ComparisonResult(List<Integer> inputNumbers, List<Integer> answerNumbers) {
        HashMap<AnswerState, Integer> compareResultMap = getCompareResult(inputNumbers, answerNumbers);

        this.result = getResultString(compareResultMap);
        this.isCorrect = Objects.equals(compareResultMap.get(AnswerState.STRIKE), MAX_STRIKE_NUMBER);
    }

    public static ComparisonResult of(List<Integer> inputNumbers, List<Integer> answerNumbers) {
        return new ComparisonResult(inputNumbers, answerNumbers);
    }

    private HashMap<AnswerState, Integer> getCompareResult(List<Integer> inputNumbers, List<Integer> answerNumbers) {
        HashMap<AnswerState, Integer> compareResultMap = new HashMap<>();

        for (int i = 0; i < VALID_ANSWER_SIZE; i++) {
            int input = inputNumbers.get(i);
            int answer = answerNumbers.get(i);

            if (answer == input) {
                compareResultMap.put(AnswerState.STRIKE, compareResultMap.getOrDefault(AnswerState.STRIKE, 0) + 1);
            } else if (inputNumbers.contains(answer)) {
                compareResultMap.put(AnswerState.BALL, compareResultMap.getOrDefault(AnswerState.BALL, 0) + 1);
            }
        }

        if (compareResultMap.isEmpty()) {
            compareResultMap.put(AnswerState.NOTHING, 1);
        }

        return compareResultMap;
    }

    private String getResultString(HashMap<AnswerState, Integer> compareResultMap) {
        if (compareResultMap.containsKey(AnswerState.NOTHING)) {
            return AnswerState.NOTHING.getValue();
        }

        String ballResult = formatStatus(AnswerState.BALL, compareResultMap);
        String strikeResult = formatStatus(AnswerState.STRIKE, compareResultMap);

        return !ballResult.isEmpty() ? ballResult + " " + strikeResult : strikeResult;
    }

    private String formatStatus(AnswerState status, HashMap<AnswerState, Integer> map) {
        return map.containsKey(status) ? map.get(status).toString() + status.getValue() : "";
    }

    public String getResult() {
        return result;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
