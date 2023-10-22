package baseball.domain;

import baseball.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static baseball.validator.NumberValidator.*;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Number {
    private static final int RANDOM_NUMBER_MINIMUM = 1;
    private static final int RANDOM_NUMBER_MAXIMUM = 9;
    private static final int NUMBER_LENGTH = 3;

    private final List<Integer> numbers;

    // Player Number Constructor
    private Number(String input) {
        validateEmpty(input);
        validateNumberLength(input);
        validateContainOnlyNumber(input);
        validateContainDuplicatedNumber(input);

        this.numbers = convertInputNumber(input);
    }

    // Computer Number Constructor
    private Number(List<Integer> computerNumber) {
        this.numbers = computerNumber;
    }

    // Player Number Static Factory Method
    public static Number inputPlayerNumbers() {
        String playerNumbers = InputView.requestUserNumbers();
        return new Number(playerNumbers);
    }

    // Computer Number Static Factory Method
    public static Number generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < NUMBER_LENGTH) {
            int number = pickNumberInRange(RANDOM_NUMBER_MINIMUM, RANDOM_NUMBER_MAXIMUM);
            if (!randomNumbers.contains(number)) {
                randomNumbers.add(number);
            }
        }
        return new Number(randomNumbers);
    }

    private List<Integer> convertInputNumber(String input) {
        return input.chars()
                .mapToObj(Character::getNumericValue)
                .toList();
    }

    public int countBallCount(final Number comparableNumber) {
        return (int) IntStream.range(0, numbers.size())
                .filter(i -> comparableNumber.isBall(numbers.get(i), i))
                .count();
    }

    public int countStrikeCount(final Number comparableNumber) {
        return (int) IntStream.range(0, numbers.size())
                .filter(i -> comparableNumber.isStrike(numbers.get(i), i))
                .count();
    }

    // Ball : Contain their number at other position
    private boolean isBall(int number, int digit) {
        return !isStrike(number, digit) && numbers.contains(number);
    }

    // Strike : Contain their number at same digit
    private boolean isStrike(int number, int digit) {
        return number == numbers.get(digit);
    }
}
