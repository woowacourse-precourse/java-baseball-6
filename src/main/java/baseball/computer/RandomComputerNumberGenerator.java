package baseball.computer;

import static baseball.validator.NumberValidator.MAX_VALUE;
import static baseball.validator.NumberValidator.MIN_VALUE;
import static baseball.validator.NumberValidator.isBelowRequiredLength;
import static baseball.validator.NumberValidator.validateDuplicateNumber;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomComputerNumberGenerator {

    private final Set<Number> numbers;

    public RandomComputerNumberGenerator() {
        this.numbers = new LinkedHashSet<>();

        while (isBelowRequiredLength(numbers.size())) {
            int randomNumber = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
            validateDuplicateNumber(randomNumber);
            numbers.add(new Number(randomNumber));
        }
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(Number::toString)
                .collect(Collectors.joining());
    }

}
