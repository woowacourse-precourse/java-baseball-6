package baseball.start;

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

    public void pickAnswerNumbers() {
        if (answer.size() > 0) {
            answer = new ArrayList<>();
        }
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }
}
