package baseball.domain;

import baseball.GuessResult;
import baseball.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BaseballNumbers {

    private static final int NUMBERS_SIZE = 3;
    private static final String ERROR_NO_DUPLICATE_NUMBER_ALLOW = "중복되지 않은 숫자를 입력해주세요.";
    private static final String ERROR_NUMBER_SIZE_NOT_ALLOW = "숫자 %d개만 입력 가능합니다.";
    private final List<BaseballNumber> numbers;

    public BaseballNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateIsAllDifferentNumbers(numbers);
        this.numbers = initialize(numbers);
    }

    public BaseballNumbers(NumberGenerator generator) {
        numbers = new ArrayList<>();
        initialize(generator);
    }

    public GuessResult guess(BaseballNumbers guessNumbers) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < numbers.size(); i++) {
            BaseballNumber answerNumber = getNumber(i);
            BaseballNumber guessNumber = guessNumbers.getNumber(i);
            strike = calculateStrikeCount(answerNumber, guessNumber, strike);
            ball = calculateBallCount(answerNumber, guessNumber, ball);
        }

        return new GuessResult(strike, ball, isCorrect(strike));
    }

    private int calculateBallCount(BaseballNumber answerNumber,
                                   BaseballNumber guessNumber,
                                   int ballCount) {
        if (isBall(answerNumber, guessNumber)) {
            ballCount++;
        }
        return ballCount;
    }

    private int calculateStrikeCount(BaseballNumber answerNumber,
                                     BaseballNumber guessNumber,
                                     int strikeCount) {
        if (isStrike(answerNumber, guessNumber)) {
            strikeCount++;
        }
        return strikeCount;
    }

    private boolean isCorrect(int strike) {
        return strike == NUMBERS_SIZE;
    }

    private boolean isBall(BaseballNumber answerNumber,
                           BaseballNumber guessNumber) {
        return !isStrike(answerNumber, guessNumber) && contains(guessNumber);
    }

    private boolean isStrike(BaseballNumber answerNumber, BaseballNumber guessNumber) {
        return answerNumber.equals(guessNumber);
    }

    private BaseballNumber getNumber(int index) {
        return numbers.get(index);
    }

    private boolean contains(BaseballNumber number) {
        return numbers.contains(number);
    }

    private List<BaseballNumber> initialize(List<Integer> numbers) {
        return numbers.stream()
                .map(BaseballNumber::new)
                .toList();
    }

    private void initialize(NumberGenerator generator) {
        while (numbers.size() < NUMBERS_SIZE) {
            BaseballNumber number = new BaseballNumber(generator);
            addIfUnique(number);
        }
    }

    private void addIfUnique(BaseballNumber number) {
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }

    private void validateIsAllDifferentNumbers(List<Integer> numbers) {
        Set<Integer> numbersSet = Set.copyOf(numbers);
        if (numbersSet.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(ERROR_NO_DUPLICATE_NUMBER_ALLOW);
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(ERROR_NUMBER_SIZE_NOT_ALLOW.formatted(NUMBERS_SIZE));
        }
    }
}
