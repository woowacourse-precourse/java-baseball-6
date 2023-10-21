package baseball;

import java.util.HashSet;
import java.util.Set;

public class InputValidation {

    public void validateNumber(String threeNumber) {
        validateThreeNumber(threeNumber);
        validateOneToNine(threeNumber);
        validateDifferentNumber(threeNumber);
    }

    private void validateThreeNumber(String threeNumber) {
        if (threeNumber.length() != 3) {
            throw new IllegalArgumentException("세자리 숫자가 아닙니다.");
        }
    }

    private void validateOneToNine(String threeNumber) {
        for (int i = 0; i < 3; i++) {
            if (threeNumber.charAt(i) < '1' && threeNumber.charAt(i) > '9') {
                throw new IllegalArgumentException("1-9까지의 숫자가 아닙니다.");
            }
        }
    }

    private void validateDifferentNumber(String threeNumber) {
        Set<Character> numbers = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            numbers.add(threeNumber.charAt(i));
        }
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("중복된 숫자를 입력하였습니다.");
        }
    }

    public boolean validateMenuNumber(String stringMenuNumber) {
        int menuNumber = Integer.parseInt(stringMenuNumber);
        if (menuNumber != 1 && menuNumber != 2) {
            throw new IllegalArgumentException("메뉴에 있는 숫자가 아닙니다.");
        }
        return true;
    }
}
