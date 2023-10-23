package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class AnswerCreator {
    private List<Integer> computerAnswer = new ArrayList<>();

    public List<Integer> getComputerAnswer() {
        return computerAnswer;
    }

    public void setComputerAnswer() {
        while (computerAnswer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerAnswer.contains(randomNumber)) {
                computerAnswer.add(randomNumber);
            }
        }
    }

}
