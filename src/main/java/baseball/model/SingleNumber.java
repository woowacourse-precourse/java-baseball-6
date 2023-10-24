package baseball.model;

import baseball.service.ValidatorFactory;
import baseball.validation.Validator;

public class SingleNumber {

    private final Integer number;

    public SingleNumber(String target) {
        validate(target);
        this.number = Integer.parseInt(target);
    }

    private void validate(String target) {
        Validator validator = ValidatorFactory.getValidator(target.getClass());
        validator.validate(target);
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
