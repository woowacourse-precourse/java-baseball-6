package game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static constant.Constant.*;

public class Computer {
    
    private final List<Integer> answer;

    public Computer() {
        answer = new ArrayList<>();
        while (answer.size() < ANSWER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public List<Integer> getAnswer() {
        return answer;
    }
}
