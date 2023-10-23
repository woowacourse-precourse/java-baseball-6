package baseball.model.computer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameAnswer {

    private static final Integer BALL_SIZE = 3;
    private final static Integer FIRST_NUMBER = 1;
    private final static Integer LAST_NUMBER = 9;

    private List<Integer> answer;

    public GameAnswer() {
        this.answer = new ArrayList<>();
    }

    public void makeAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < BALL_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(FIRST_NUMBER, LAST_NUMBER);
            addIfNotInList(computer, randomNumber);
        }
        this.answer = computer;
    }

    private void addIfNotInList(List<Integer> answer, int randomNumber) {
        if (!answer.contains(randomNumber)) {
            answer.add(randomNumber);
        }
    }

    public List<Integer> getAnswer() {
        return answer;
    }
}
