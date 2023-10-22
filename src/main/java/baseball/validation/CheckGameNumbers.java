package baseball.validation;

import java.util.HashSet;
import java.util.Set;

class ConstExceptionMessages {
    public static final String THREE_DIGIT_EXCEPTION_MSG = "세 자리 입력이 아닙니다.";
    public static final String RANGE_EXCEPTION_MSG = "입력 범위가 올바르지 않습니다. 1이상 9이하의 숫자를 입력해야 합니다.";
    public static final String DIFF_EACH_OTHER_EXCEPTION_MSG = "서로 다른 수를 입력해야 합니다.";
}

class ThreeDigitException extends IllegalArgumentException {
    ThreeDigitException() {
        super(ConstExceptionMessages.THREE_DIGIT_EXCEPTION_MSG);
    }
}

class NumberRangeException extends IllegalArgumentException {
    NumberRangeException() {
        super(ConstExceptionMessages.RANGE_EXCEPTION_MSG);
    }
}

class DifferentEachOtherException extends IllegalArgumentException {
    DifferentEachOtherException() {
        super(ConstExceptionMessages.DIFF_EACH_OTHER_EXCEPTION_MSG);
    }
}


public class CheckGameNumbers {
    public void checkValidation(String in)
            throws ThreeDigitException, NumberRangeException, DifferentEachOtherException {
        if (!isThreeDigitNumbers(in)) {
            throw new ThreeDigitException();
        }
        if (!isRightRangeNumbers(in)) {
            throw new NumberRangeException();
        }
        if (!isDifferentEachOther(in)) {
            throw new DifferentEachOtherException();
        }
    }

    private boolean isThreeDigitNumbers(String in) {
        if (in.length() != 3) {
            return false;
        }
        return true;
    }

    private boolean isRightRangeNumbers(String in) {
        for (int i = 0; i < in.length(); i++) {
            if (!isRightRangeNumber(in.charAt(i) - '0')) {
                return false;
            }
        }
        return true;
    }

    private boolean isRightRangeNumber(int num) {
        return num >= 1 && num <= 9;
    }

    private boolean isDifferentEachOther(String in) {
        Set<Character> prevNum = new HashSet<>();
        for (int i = 0; i < in.length(); i++) {
            if (prevNum.contains(in.charAt(i))) {
                return false;
            }
            prevNum.add(in.charAt(i));
        }
        return true;
    }
}
