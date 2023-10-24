package baseball.model;

import static baseball.util.Constants.ANSWER_SIZE;
import static baseball.util.Constants.BALL;
import static baseball.util.Constants.NOTHING;
import static baseball.util.Constants.STRIKE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private List<Integer> answer = new ArrayList<>();

    public void createAnswer(List<Integer> answer) {
        validateSize(answer);
        validateDuplication(answer);
        this.answer = answer;
    }

    public Boolean isEqual(List<Integer> userAnswer) {
        return answer.equals(userAnswer);
    }

    public int isBallOrStrike(int num, int index) {
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i) == num && i == index) {
                return STRIKE;
            }
            if (answer.get(i) == num && i != index) {
                return BALL;
            }
        }
        return NOTHING;
    }

    private void validateSize(List<Integer> answer) {
        if (answer.size() != ANSWER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> answer) {
        Set<Integer> noDuplication = new HashSet<>(answer);
        if (noDuplication.size() != answer.size()) {
            throw new IllegalArgumentException();
        }
    }
}
