package baseball;
import java.util.HashSet;
import java.util.Set;

public class ExceptionContoller {

    public void notIntegerException(String Number) {
        for (int i = 0; i < NumberInfo.SIZE_OF_NUMBER.getNumberInfo(); i++) {
            if (!Character.isDigit(Number.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void reduplicationException(String Number) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < NumberInfo.SIZE_OF_NUMBER.getNumberInfo(); i++) {
            set.add(Number.charAt(i));
        }
        if (!(set.size() == NumberInfo.SIZE_OF_NUMBER.getNumberInfo())) {
            throw new IllegalArgumentException();
        }
    }

    public void notThreeDigitException(String Number) {
        if (Number.length() != NumberInfo.SIZE_OF_NUMBER.getNumberInfo()) {
            throw new IllegalArgumentException();
        }
    }

    public void zeroValueException(String Number) {
        for (int i = 0; i < NumberInfo.SIZE_OF_NUMBER.getNumberInfo(); i++) {
            if (Number.charAt(i) == '0') {
                throw new IllegalArgumentException();
            }
        }
    }
}