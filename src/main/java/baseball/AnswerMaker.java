package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnswerMaker {
    private List<Integer> answer;

    public void makeAnswer(int min, int max) {
        this.answer = new ArrayList<>(makeThreeDifferentNumbers(min, max));
    }

    private int makeNumberInRange(int min, int max) {
        return (Randoms.pickNumberInRange(min, max));
    }

    private List<Integer> makeThreeDifferentNumbers(int min, int max) {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < 3) {
            numbers.add(makeNumberInRange(min, max));
        }
        return new ArrayList<>(numbers);
    }


    public List<Integer> getAnswer() {
        return answer;
    }
}
