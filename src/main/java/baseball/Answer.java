package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Answer {
    private static final char ZERO_CHAR = '0';
    private static final int ANSWER_LENGTH = 3;
    private static int ball;
    private static int strike;
    private List<Integer> input;
    private final List<Integer> answer = new ArrayList<>();

    public Answer() {
        // answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public GradeResult gradeInput(String answerInput) {

        strike = 0;
        ball = 0;
        input = new ArrayList<>();

        for (char number : answerInput.toCharArray()) {
            input.add(charToInt(number));
        }

        compareAnswerWithInput();

        return GradeResult.of(ball, strike);
    }

    private void compareAnswerWithInput() {
        for (int answerIndex = 0; answerIndex < ANSWER_LENGTH; answerIndex++) {
            for (int inputIndex = 0; inputIndex < ANSWER_LENGTH; inputIndex++) {
                increaseValue(answerIndex, inputIndex);
            }
        }
    }

    private void increaseValue(int answerIndex, int inputIndex) {
        if (answer.get(answerIndex).equals(input.get(inputIndex))) {
            if (answerIndex == inputIndex) {
                strike += 1;
                return;
            }
            ball += 1;
        }
    }

    private int charToInt(char number) {
        return number - ZERO_CHAR;
    }
}
