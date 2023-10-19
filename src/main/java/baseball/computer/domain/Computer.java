package baseball.computer.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> randomAnswer;

    public Computer() {
        this.randomAnswer = new ArrayList<>();
    }

    public List<Integer> createRandomAnswer() {
        while (randomAnswer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomAnswer.contains(randomNumber)) {
                randomAnswer.add(randomNumber);
            }
        }
        return randomAnswer;
    }

}
