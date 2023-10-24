package baseball.collaborator.number;

import baseball.collaborator.number.generator.NumbersGenerator;
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
