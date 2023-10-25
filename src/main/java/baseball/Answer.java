package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Answer {
    private List<Integer> number;
    public static final Answer answer = new Answer();

    public void generateAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < Validate.BASEBALL_NUM_OF_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(Validate.BASEBALL_START_DIGITS,
                    Validate.BASEBALL_END_DIGITS);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        this.number = answer;
    }

    public List<Integer> getNumber() {
        return number;
    }
}
