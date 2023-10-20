package baseball.computer;

import static baseball.validator.NumberValidator.validateNaturalNumber;

public class Number {

    private final int number;

    public Number(int randomNumber) {
        validateNaturalNumber(randomNumber);
        this.number = randomNumber;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

}
