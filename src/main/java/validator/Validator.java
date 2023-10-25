package validator;

import constant.Numeric;

import java.util.List;

public class Validator {
    public void validateStringLength(String str) throws IllegalArgumentException {
        if (str.length() != Numeric.NUMBER_OF_INPUT) {
            throw new IllegalArgumentException();
        }
    }

    public void validateNumberRange(Integer integer) throws IllegalArgumentException {
        if (integer < 1 || integer > 9) {
            throw new IllegalArgumentException();
        }
    }

    public void validateDuplicateNumbers(List<Integer> list, Integer integer) {
        if (list.contains(integer)) {
            throw new IllegalArgumentException();
        }
    }
}
