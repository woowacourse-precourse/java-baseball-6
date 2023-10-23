package baseball.domain;

import baseball.util.MagicNumber;

import java.util.List;

import static baseball.util.MagicNumber.*;

public class Number {

    public void validateNumber(List<Integer> number) {
        validateNumberSize(number);
        validateDuplicateNumber(number);
        validateNumberLength(number);
    }

    public void validateNumberSize(List<Integer> number) {
        if(number.size() != MAX_SIZE.getNumber()) {
            throw new IllegalArgumentException("숫자의 개수가 올바르지 않습니다. (숫자는 반드시 세개로 구성되어야합니다)");
        }
    }

    public void validateNumberLength(List<Integer> number) {
        boolean isValid = number.stream()
                .allMatch(numbers -> numbers >= MIN_NUMBER.getNumber() && numbers <= MAX_NUMBER.getNumber());

        if (!isValid) {
            throw new IllegalArgumentException("숫자는 1에서 9 사이여야 합니다.");
        }
    }

    public void validateDuplicateNumber(List<Integer> number) {
        List<Integer> numberStorage = number.stream().distinct().toList();

        if(numberStorage.size() != MAX_SIZE.getNumber()) {
            throw new IllegalArgumentException("중복 숫자는 허용하지 않습니다.");
        }
    }

}
