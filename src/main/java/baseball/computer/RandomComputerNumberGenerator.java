package baseball.computer;

import static baseball.validator.NumberValidator.MAX_VALUE;
import static baseball.validator.NumberValidator.MIN_VALUE;
import static baseball.validator.NumberValidator.isBelowThreeLength;
import static baseball.validator.NumberValidator.validateDuplicateNumber;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomComputerNumberGenerator {

    private final Set<Integer> numbers;

    public RandomComputerNumberGenerator() {
        this.numbers = new LinkedHashSet<>();

        while (isBelowThreeLength(numbers.size())) {
            int randomNumber = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
            numbers.add(randomNumber);
        }
    }

    @Override
    public String toString() {
        String numberString = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        validateDuplicateNumber(Integer.parseInt(numberString));

        return numberString;
    }

}
