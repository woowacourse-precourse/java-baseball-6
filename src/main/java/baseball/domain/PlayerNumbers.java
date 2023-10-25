package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerNumbers {

    private final List<Integer> numbers;

    public PlayerNumbers(String numbers) throws IllegalArgumentException {
        List<Integer> integerNumbers = this.convertStringToList(numbers);
        this.validateNumbers(integerNumbers);
        this.numbers = integerNumbers;
    }

    private List<Integer> convertStringToList(String numbers) {
        List<Integer> numbersInteger = new ArrayList<>();

        for (String number : numbers.split("")) {
            numbersInteger.add(Integer.parseInt(number));
        }
        return numbersInteger;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.isEmpty()) throw new IllegalArgumentException("입력값이 비었다.");
        if (numbers.size() != 3) throw new IllegalArgumentException("3자리만 입력해라.");
        this.validateContainsDuplicateNumber(numbers);
    }

    private void validateContainsDuplicateNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            if (!set.add(number)) {
                throw new IllegalArgumentException("중복된 값이 존재한다.");
            }
        }
    }

    public Result checkResult(BaseballNumbers baseballNumbers) {
        int strike = 0, ball = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (baseballNumbers.isBall(numbers.get(i))) ball++;
            if (baseballNumbers.isStrike(i, numbers.get(i))) strike++;
        }
        ball -= strike;

        return new Result(strike, ball);
    }
}
