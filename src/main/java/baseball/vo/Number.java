package baseball.vo;

import static baseball.enums.NumbersEnum.MAX_VALUE;
import static baseball.enums.NumbersEnum.MIN_VALUE;

import baseball.enums.NumbersEnum;
import baseball.exception.NumberRangeException;
import java.util.Objects;

public class Number {

    private int number;

    public Number(int number) {
        checkRange(number);
        this.number = number;
    }


    private void checkRange(int number) {
        if (number < MIN_VALUE.showValue() || number > MAX_VALUE.showValue()) {
            throw new NumberRangeException();
        }
    }

    public int showValue() {
        return this.number;
    }

    @Override
    public boolean equals(Object object) {
        Number otherNumber = (Number)object;

        return this.number == otherNumber.showValue();

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.number);
    }



}
