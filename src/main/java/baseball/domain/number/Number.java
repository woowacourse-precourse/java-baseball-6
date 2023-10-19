package baseball.domain.number;

import baseball.domain.validation.Validation;
import java.util.List;

public class Number {

    private final List<Integer> number;

    public Number(String inputNumber) {
        List<Integer> number = stringToIntegerList(inputNumber);
        validNumber(inputNumber, number);
        this.number = number;
    }

    private List<Integer> stringToIntegerList(String inputNumber) {
        return inputNumber.chars()
                .map(Character::getNumericValue)
                .boxed()
                .toList();
    }

    private static void validNumber(String stringNumber, List<Integer> stringToInteger) {
        if (!Validation.isInteger(stringNumber)) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        } else if (Validation.isAvailLength(stringToInteger)) {
            throw new IllegalArgumentException("세자리 숫자를 입력해주세요.");
        } else if (Validation.isDuplicate(stringToInteger)) {
            throw new IllegalArgumentException("서로 다른 세자리 수를 입력해주세요.");
        } else if (Validation.isAvailRange(stringToInteger)) {
            throw new IllegalArgumentException("1 부터 9 사이의 숫자만 입력 가능합니다.");
        }
    }


}
