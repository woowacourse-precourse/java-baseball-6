package baseball.domain;

import baseball.exception.BaseballGameException;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {
    private static final int SIZE = 3;
    private static final int MIN = 1;
    private static final int MAX = 9;

    private final List<Integer> numbers;

    private BaseballNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = List.copyOf(numbers);
    }

    public static BaseballNumbers randomNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < SIZE) {
            int number = Randoms.pickNumberInRange(MIN, MAX);
            if (!randomNumbers.contains(number)) {
                randomNumbers.add(number);
            }
        }
        return new BaseballNumbers(randomNumbers);
    }

    public static BaseballNumbers from(String input) {
        List<Integer> parsed = input.chars()
                .map(c -> c - '0')
                .boxed()
                .toList();
        return new BaseballNumbers(parsed);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new BaseballGameException("숫자는 " + SIZE + "자리여야 합니다.");
        }
        if (numbers.stream().anyMatch(n -> n < MIN || n > MAX)) {
            throw new BaseballGameException(MIN + "~" + MAX + " 사이의 숫자여야 합니다.");
        }
        if (numbers.stream().distinct().count() != SIZE) {
            throw new BaseballGameException("서로 다른 숫자여야 합니다.");
        }
    }

    public GameResult judge(BaseballNumbers userNumber) {
        int strike = 0;
        int ball = 0;
        for(int index = 0; index < numbers.size(); index++){
            if(isCurrentDigitStrike(userNumber, index)){
                strike++;
                continue;
            }

            if(isCurrentDigitBall(userNumber, index)){
                ball++;
            }
        }
        return GameResult.from(strike, ball);
    }

    private boolean isCurrentDigitBall(BaseballNumbers userNumber, int index) {
        return numbers.contains(userNumber.numbers.get(index));
    }

    private boolean isCurrentDigitStrike(BaseballNumbers userNumber, int index) {
        return numbers.get(index).equals(userNumber.numbers.get(index));
    }
}