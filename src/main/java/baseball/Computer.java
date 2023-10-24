package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> answer;

    private Computer(List<Integer> answer) {
        this.answer = answer;
    }

    public static Computer create() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

        return new Computer(answer);
    }

    public List<Integer> getAnswer() {
        return this.answer;
    }

}
