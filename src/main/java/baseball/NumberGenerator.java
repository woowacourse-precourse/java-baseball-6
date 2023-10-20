package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    public Answer createAnswer() {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            isAnswerHasDuplicatedValue(answer, Randoms.pickNumberInRange(1, 9));
        }

        return new Answer(answer);
    }

    private void isAnswerHasDuplicatedValue(List<Integer> answer, int randNum) {
        if (!answer.contains(randNum)) {
            answer.add(randNum);
        }
    }
}
