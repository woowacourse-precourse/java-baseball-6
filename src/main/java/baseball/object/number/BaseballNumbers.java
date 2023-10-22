package baseball.object.number;

import baseball.object.number.generator.NumbersGenerator;
import java.util.List;

public class BaseballNumbers {

    private NumbersGenerator numbersGenerator;
    private List<Integer> baseballNumbers;

    public BaseballNumbers(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
        this.baseballNumbers = numbersGenerator.generate();
    }

    public List<Integer> get() {
        return baseballNumbers;
    }

}
