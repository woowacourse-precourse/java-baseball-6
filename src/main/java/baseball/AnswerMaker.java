package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnswerMaker {
    public int makeNumbers(int min, int max) {
        return (Randoms.pickNumberInRange(min, max));
    }

    public List<Integer> makeThreeDifferentNumberList(int min, int max) {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 3) {
            numbers.add(makeNumbers(min, max));
        }
        return new ArrayList<>(numbers);
    }
}
