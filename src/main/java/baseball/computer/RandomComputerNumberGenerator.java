package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomComputerNumberGenerator {

    private static final int LENGTH = 3;
    private final Set<Number> numbers;

    public RandomComputerNumberGenerator() {
        this.numbers = new LinkedHashSet<>();

        while (numbers.size() < LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
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
