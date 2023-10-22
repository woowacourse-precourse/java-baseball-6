package baseball.validator;

import java.util.HashSet;
import java.util.Set;

public class Validator {
    private static final int MAX_LENGTH = 3;

    public Validator() {
    }

    public void verifyForRedo(String input) {
        verifyNullAndEmpty(input);
        verifyNumber(input);
        verifyOneAndTwo(input);
    }

    public void verifyForBaseballNumber(String input) {
        verifyNullAndEmpty(input);
        verifyLength(input);
        verifyNumber(input);
        verifyUniqueNumber(input);
    }

    private void verifyNullAndEmpty(String input){
        if(input == null || input.isBlank()){
            throw new IllegalArgumentException("null 이거나 빈 문자열은 또는 공백으로 이루어질 수 없습니다.");
        }
    }

    private void verifyOneAndTwo(String input) {
        int number = Integer.parseInt(input);
        if (number < 1 || number > 2) {
            throw new IllegalArgumentException("1 또는 2가 아닙니다.");
        }
    }

    private void verifyUniqueNumber(String input) {
        Set<Character> numbers = new HashSet<>();
        for (char character : input.toCharArray()) {
            numbers.add(character);
        }

        if (numbers.size() != MAX_LENGTH) {
            throw new IllegalArgumentException("유니크한 값이 아닙니다.");
        }
    }

    private void verifyNumber(String input) {
        for (char character : input.toCharArray()) {
            if (!Character.isDigit(character)) {
                throw new IllegalArgumentException("숫자 형식이 아닙니다.");
            }
        }
    }

    private void verifyLength(String input) {
        if (input.length() != MAX_LENGTH) {
            throw new IllegalArgumentException("입력 길이가 3이 아닙니다.");
        }
    }
}
