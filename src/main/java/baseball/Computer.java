package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int ANSWER_LENGTH = 3;
    private static final int MINIMUM_DIGIT_RANGE = 1;
    private static final int MAXIMUM_DIGIT_RANGE = 9;
    int answer;

    public List<Integer> createAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < ANSWER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MINIMUM_DIGIT_RANGE, MAXIMUM_DIGIT_RANGE);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }
}
