package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int ANSWER_SIZE = 3;
    private static final int ANSWER_MIN_NUM = 1;
    private static final int ANSWER_MAX_NUM = 9;

    public List<Integer> makeAnswer() {
        List<Integer> computerAnswer = new ArrayList<>();
        while(computerAnswer.size()<ANSWER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(ANSWER_MIN_NUM, ANSWER_MAX_NUM);
            if (!computerAnswer.contains(randomNumber)) {
                computerAnswer.add(randomNumber);
            }
        }
        return computerAnswer;
    }
}