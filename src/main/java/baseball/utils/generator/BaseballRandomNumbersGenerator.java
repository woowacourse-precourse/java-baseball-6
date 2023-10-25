package baseball.utils.generator;

import baseball.number.Number;
import baseball.number.Numbers;

public class BaseballRandomNumbersGenerator extends RandomNumberGenerator {

    public Numbers generateNumbers() {
        Numbers numbers = new Numbers();

        while (numbers.isMoreSelect()) {
            Number number = super.generate();
            numbers.add(number);
        }

        return numbers;
    }
}
