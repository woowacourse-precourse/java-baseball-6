package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Problem {

    private final List<Integer> answer;
    private static final int UNIQUE_NUMBER_MIN = 1;
    private static final int UNIQUE_NUMBER_MAX = 9;

    public Problem() {
        this.answer = createAnswer();
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    protected List<Integer> createAnswer() {
        List<Integer> createAnswer = new ArrayList<>();
        while (createAnswer.size()!=3) {
            int randomNumber = Randoms.pickNumberInRange(UNIQUE_NUMBER_MIN, UNIQUE_NUMBER_MAX);
            if (!createAnswer.contains(randomNumber)) {
                createAnswer.add(randomNumber);
            }
        }
        return createAnswer;
    }

}
