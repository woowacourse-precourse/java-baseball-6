package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private static final Integer MIN_NUMBER = 1;
    private static final Integer MAX_NUMBER = 9;
    private static final Integer COUNT_NUMBER = 3;

    public void start() {
        while (true) {
            List<Integer> baseballNumbers = this.generateBaseballNumbers();
        }
    }

    public List<Integer> generateBaseballNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < COUNT_NUMBER) {
            int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }
}
