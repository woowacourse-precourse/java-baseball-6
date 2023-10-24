package validator;

import java.util.List;

public class Validator {
    // input의 길이 체크
    public void validateStringLength(String str) throws IllegalArgumentException {
        if (str.length() != 3) {
            throw new IllegalArgumentException(); // "길이가 3이 아닙니다."
        }
    }
    // 1부터 9까지의 수인지 체크
    public void validateNumberRange(Integer integer) throws IllegalArgumentException {
        if (integer < 1 || integer > 9) {
           throw new IllegalArgumentException();
        }
    }
    // 중복된 숫자가 포함되어 있는지 체크
    public void validateDuplicateNumbers(List<Integer> list, Integer integer) {
        if (list.contains(integer)) {
            throw new IllegalArgumentException();
        }
    }
}
