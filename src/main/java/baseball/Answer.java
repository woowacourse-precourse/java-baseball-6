package baseball;

import static baseball.Constants.COUNT;
import static baseball.Constants.END_INCLUSIVE;
import static baseball.Constants.START_INCLUSIVE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Answer {

    private List<Integer> answer;

    public Answer() {
        answer = new ArrayList<>();
    }

    public List<Integer> getAnswer() {
        return this.answer;
    }

    public List<Integer> pickAnswerNumbers() {
        answer = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
        return answer;
    }
}
