package baseball.object.number;

import baseball.object.number.generator.NumbersGenerator;
import java.util.List;

public class BaseballNumbers {

    private final List<Integer> baseballNumbers;

    public BaseballNumbers(NumbersGenerator numbersGenerator) {
        this.baseballNumbers = List.copyOf(numbersGenerator.generate());
    }

    public List<Integer> get() {
        return baseballNumbers;
    }

}
