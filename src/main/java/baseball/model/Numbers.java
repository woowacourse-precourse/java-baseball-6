package baseball.model;

import baseball.util.constants.BaseballGameConstants;
import baseball.util.constants.ExceptionMessages;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;

public class Numbers {
    private final int[] numbers;

    private Numbers(int size) {
        this.numbers = new int[size];
    }

    private Numbers(int[] numbers) {
        this.numbers = numbers;
        validate();
    }

    public static Numbers create(int[] numbers) {
        return new Numbers(numbers);
    }

    public static Numbers random() {
        Numbers result = new Numbers(BaseballGameConstants.NUM_LENGTH);
        int idx = 0;
        while (idx < BaseballGameConstants.NUM_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(BaseballGameConstants.MIN_NUM, BaseballGameConstants.MAX_NUM);
            if (result.contains(randomNumber)) {
                continue;
            }
            result.numbers[idx++] = randomNumber;
        }
        result.validate();
        return result;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, numbers.length);
    }

    private boolean contains(int value) {
        for (int number : numbers) {
            if (number == value) {
                return true;
            }
        }
        return false;
    }

    public BallCount compare(Numbers other) {
        if (other == null || numbers.length != other.numbers.length) {
            throw new IllegalArgumentException();
        }

        int strike = 0;
        int ball = 0;

        int[] otherNumbers = other.getNumbers();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == otherNumbers[i]) {
                strike++;
            } else if (other.contains(numbers[i])) {
                ball++;
            }
        }

        return new BallCount(strike, ball);
    }


    private void validate() {
        validateLength();
        for (int n : numbers) {
            validateRange(n);
        }
        validateNoDuplicates();
    }

    private void validateLength() {
        if (numbers.length != BaseballGameConstants.NUM_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessages.NUMBERS_WRONG_LENGTH);
        }
    }

    private void validateRange(int n) {
        if (n < BaseballGameConstants.MIN_NUM || n > BaseballGameConstants.MAX_NUM) {
            throw new IllegalArgumentException(ExceptionMessages.NUMBERS_OUT_OF_RANGE);
        }
    }

    private void validateNoDuplicates() {
        long distinctCount = Arrays.stream(numbers).distinct().count();
        if (numbers.length != distinctCount) {
            throw new IllegalArgumentException(ExceptionMessages.NUMBERS_DUPLICATED_MESSAGE);
        }
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Numbers numbers1 = (Numbers) o;
        return Arrays.equals(numbers, numbers1.numbers);
    }

    @Override
    public String toString() {
        return "Numbers{" + Arrays.toString(numbers) + '}';
    }
}
