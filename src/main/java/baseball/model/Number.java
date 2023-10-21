package baseball.model;

import java.util.List;

public class Number {
    public final int firstNumber;
    public final int secondNumber;
    public final int thirdNumber;

    public Number(List<Integer> numbers) {
        firstNumber = numbers.get(0);
        secondNumber = numbers.get(1);
        thirdNumber = numbers.get(2);
    }

}
