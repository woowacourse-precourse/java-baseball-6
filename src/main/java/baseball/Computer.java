package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> answer;

    public Computer() {
        makeAnswer();
    }

    private void makeAnswer() {
        answer = new ArrayList<>();

        while (answer.size() < 3) {
            addRandomNumber();
        }
    }

    private void addRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!answer.contains(randomNumber)) {
            answer.add(randomNumber);
        }
    }
    
}
