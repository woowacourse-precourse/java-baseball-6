package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    final List<Integer> answer = new ArrayList<>();

    public void createAnswer() {
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public Result judgeAnswer(List<Integer> guess, List<Integer> answer) {
        int strike = 0, ball = 0;
        for (int i = 0; i < guess.size(); i++) {
            if (!answer.contains(guess.get(i))) {
                continue;
            }
            if (answer.get(i).equals(guess.get(i))) {
                strike++;
            } else {
                ball++;
            }
        }
        return new Result(strike, ball);
    }
}
