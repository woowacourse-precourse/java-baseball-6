package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {
    private final int maxNumber = 9;
    private final int minNumber = 1;
    private List<Integer> answer = new ArrayList<Integer>();

    public NumberGenerator() {
        makeRandomAnswerList();
    }

    public void makeRandomAnswerList() {
        while (answer.size() < 3) {
            final int randomNumber = Randoms.pickNumberInRange(minNumber, maxNumber);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public List<Integer> getAnswer() {
        return this.answer;
    }
}
