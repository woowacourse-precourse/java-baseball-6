package baseball;

import java.util.HashSet;
import java.util.Set;

import static baseball.enum_class.NumberInfo.*;

public class ExceptionContoller {

    public void notIntegerException(String Number) {
        for (int i = 0; i < COUNT.getNumberInfo(); i++) {
            if (!Character.isDigit(Number.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void duplicationException(String Number) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < COUNT.getNumberInfo(); i++) {
            set.add(Number.charAt(i));
        }
        if (!(set.size() == COUNT.getNumberInfo())) {
            throw new IllegalArgumentException();
        }
    }

    public void notThreeDigitException(String Number) {
        if (Number.length() != COUNT.getNumberInfo()) {
            throw new IllegalArgumentException();
        }
    }

    public void zeroValueException(String Number) {
        for (int i = 0; i < Number.length(); i++) {
            if (Number.charAt(i) == '0') {
                throw new IllegalArgumentException();
            }
        }
    }
}