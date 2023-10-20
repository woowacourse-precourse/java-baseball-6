package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> answer;

    public Computer() {
        this.answer = new ArrayList<>();
    }

    public void createAnswer() {
        while (answer.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public List<Integer> getResultOfGuess(List<Integer> guess) {
        List<Integer> result = new ArrayList<>();
        int strike = 0, ball = 0;
        for (int i = 0; i < 3; i++) {
            if (guess.get(i).equals(answer.get(i))) {
                strike++;
            } else if (answer.contains(guess.get(i))) {
                ball++;
            }
        }

        result.add(strike);
        result.add(ball);

        return result;
    }
}
