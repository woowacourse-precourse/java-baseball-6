package baseball.validator;

import java.util.List;

public class Validator {

    public Validator() {
    }


    public void verifyNullAndEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("null 이거나 빈 문자열은 또는 공백으로 이루어질 수 없습니다.");
        }
    }

    public void verifyInRangeClosed(int start, int end, int value) {
        if (value < start || value > end) {
            throw new IllegalArgumentException(String.format("[%d ~ %d] 범위안에 속하지 않습니다. ", start, end));
        }
    }

    public void verifyUniqueNumber(List<Integer> numbers) {
        int originalSize = numbers.size();
        int uniqueSize = (int) numbers.stream().distinct().count();

        if (originalSize != uniqueSize) {
            throw new IllegalArgumentException("고유한 숫자가 아닙니다.");
        }
    }

    public void verifyNumberPerUnit(String input) {
        for (char character : input.toCharArray()) {
            if (!Character.isDigit(character)) {
                throw new IllegalArgumentException("숫자 형식이 아닙니다.");
            }
        }
    }

    public void verifyLength(String input, int limit) {
        if (input.length() != limit) {
            throw new IllegalArgumentException("입력 길이가 3이 아닙니다.");
        }
    }
}
