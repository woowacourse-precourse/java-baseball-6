package baseball.model;

import baseball.validation.SingleNumberValidator;
import baseball.validation.Validator;

public class SingleNumber {

    private final Integer number;

    public SingleNumber(String target) {
        Validator validator = new SingleNumberValidator();
        validator.validate(target);
        this.number = Integer.parseInt(target);
    }

    public SingleNumber(Integer target) {
        Validator validator = new SingleNumberValidator();
        validator.validate(target);
        this.number = target;
    }

    @Override
    public String toString() {
        return this.number.toString();
    }

    @Override
    public int hashCode() {
        return this.number.hashCode();
    }

    @Override
    public boolean equals(Object target) {
        if (this == target) {
            return true;
        }
        if (!(target instanceof SingleNumber singleNumber)) {
            return false;
        }
        return this.number.equals(singleNumber.number);
    }
}
