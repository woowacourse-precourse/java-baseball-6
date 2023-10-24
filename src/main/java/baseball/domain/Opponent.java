package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Opponent {

    private List<Integer> answerNumbers;

    public Opponent() {
        answerNumbers = new ArrayList<>();
        while (answerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!answerNumbers.contains(randomNumber)) {
                answerNumbers.add(randomNumber);
            }
        }
    }

    public List<Integer> getAnswerNumbers() {
        return answerNumbers;
    }
}
