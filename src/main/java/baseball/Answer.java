package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Answer {
    private static final char ZERO_CHAR = '0';
    private static final int ANSWER_LENGTH = 3;
    private static final String STRIKE = "strike";
    private static final String BALL = "ball";
    private static final int MINIMUM_VALUE = 1;
    private static final int MAXIMUM_VALUE = 9;
    private final List<Integer> answer;

    private Answer() {
        answer = new ArrayList<>();
        while (answer.size() < ANSWER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MINIMUM_VALUE, MAXIMUM_VALUE);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public static Answer createNewAnswer() {
        return new Answer();
    }

    public GradeResult gradeInput(String answerInput) {

        List<Integer> input = new ArrayList<>();

        for (char number : answerInput.toCharArray()) {
            input.add(charToInt(number));
        }

        Map<String, Integer> gradeResultMap = compareAnswerWithInput(input);

        return GradeResult.of(getBallCount(gradeResultMap), getStrikeCount(gradeResultMap));
    }

    private Map<String, Integer> compareAnswerWithInput(List<Integer> input) {

        Map<String, Integer> gradeResultMap = initializeResultMap();

        for (int answerIndex = 0; answerIndex < ANSWER_LENGTH; answerIndex++) {
            for (int inputIndex = 0; inputIndex < ANSWER_LENGTH; inputIndex++) {
                increaseValue(answerIndex, inputIndex, input, gradeResultMap);
            }
        }
        return gradeResultMap;
    }

    private Map<String, Integer> initializeResultMap() {
        Map<String, Integer> gradeResultMap = new HashMap<>();
        gradeResultMap.put(BALL, 0);
        gradeResultMap.put(STRIKE, 0);
        return gradeResultMap;
    }

    private void increaseValue(int answerIndex, int inputIndex, List<Integer> input,
                               Map<String, Integer> gradeResultMap) {
        if (answer.get(answerIndex).equals(input.get(inputIndex))) {
            if (answerIndex == inputIndex) {
                gradeResultMap.put(STRIKE, getStrikeCount(gradeResultMap) + 1);
                return;
            }
            gradeResultMap.put(BALL, getBallCount(gradeResultMap) + 1);
        }
    }

    private Integer getBallCount(Map<String, Integer> gradeResultMap) {
        return gradeResultMap.get(BALL);
    }

    private Integer getStrikeCount(Map<String, Integer> gradeResultMap) {
        return gradeResultMap.get(STRIKE);
    }

    private int charToInt(char number) {
        return number - ZERO_CHAR;
    }
}
