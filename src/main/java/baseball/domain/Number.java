package baseball.domain;

import java.util.List;

public class Number {

    public void validateNumberSize(List<Integer> number) {
        if(number.size() != 3) {
            throw new IllegalArgumentException("숫자의 개수가 올바르지 않습니다. (숫자는 반드시 세개로 구성되어야합니다)");
        }
    }

    public void validateNumberLength(List<Integer> number) {
        boolean isValid = number.stream()
                .allMatch(numbers -> numbers >= 1 && numbers <= 9);

        if (!isValid) {
            throw new IllegalArgumentException("숫자는 1에서 9 사이여야 합니다.");
        }
    }

}
