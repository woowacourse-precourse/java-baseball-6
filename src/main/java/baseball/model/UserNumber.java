package baseball.model;

import java.util.List;

public class UserNumber {
    private final List<Integer> number;

    public UserNumber(String number) {
        validate(number);
        this.number = StringToList(number);
    }

    private void validate(String number) {
        if(isEmpty(number)|| !isDigit(number)){
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    private boolean isEmpty(String number) {
        return number == null || number.isBlank();
    }

    private boolean isDigit(String number) {
        return number.chars().allMatch(Character::isDigit);
    }

    private List<Integer> StringToList(String number) {

    }
}
