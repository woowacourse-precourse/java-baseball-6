package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {

    private static final Integer MIN_NUMBER = 1;
    private static final Integer MAX_NUMBER = 9;
    private static final Integer COUNT_NUMBER = 3;

    private final List<Integer> numbers;

    private BaseballNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Result checkResult(PlayerNumbers playerNumbers) {
        int strike = 0, ball = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (playerNumbers.contains(numbers.get(i))) ball++;
            if (numbers.get(i).equals(playerNumbers.get(i))) strike++;
        }
        ball -= strike;

        return new Result(strike, ball);
    }

    public static BaseballNumbers generateBaseballNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < COUNT_NUMBER) {
            int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return new BaseballNumbers(numbers);
    }
}
