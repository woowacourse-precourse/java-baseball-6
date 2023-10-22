package baseball;

import java.util.HashSet;
import java.util.Set;

public class InputValidation {
    private static final String START_GAME_OPTION = "1";
    private static final String END_GAME_OPTION = "2";

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
        for (int index = 0; index < 3; index++) {
            if (threeNumber.charAt(index) < '1' && threeNumber.charAt(index) > '9') {
                throw new IllegalArgumentException("1-9까지의 숫자가 아닙니다.");
            }
        }
    }

    private void validateDifferentNumber(String threeNumber) {
        Set<Character> numbers = new HashSet<>();
        for (int index = 0; index < 3; index++) {
            numbers.add(threeNumber.charAt(index));
        }
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("중복된 숫자를 입력하였습니다.");
        }
    }

    public boolean validateOptionNumber(String stringMenuNumber) {
        if (!stringMenuNumber.equals(START_GAME_OPTION) &&
                !stringMenuNumber.equals(END_GAME_OPTION)) {
            throw new IllegalArgumentException("옵션에 있는 숫자가 아닙니다.");
        }
        return true;
    }
}
