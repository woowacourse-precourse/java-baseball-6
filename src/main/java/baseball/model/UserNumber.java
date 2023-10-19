package baseball.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserNumber {
    private final static int MINIMUM_NUM_IN_RANGE = 1;
    private final static int MAXIMUM_NUM_IN_RANGE = 9;
    private final static int LIST_SIZE = 3;
    private final List<Integer> number;

    public UserNumber(String number) {
        validate(number);
        this.number = StringToList(number);
    }

    private void validate(String number) {
        if(isEmpty(number)|| !isDigit(number)){
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
        else if(!isThreeDigit(number)){
            throw new IllegalArgumentException("세자리 숫자를 입력해주세요");
        }
    }

    private boolean isEmpty(String number) {
        return number == null || number.isBlank();
    }

    private boolean isDigit(String number) {
        return number.chars().allMatch(Character::isDigit);
    }

    private boolean isThreeDigit(String number) {
        return number.length() == LIST_SIZE;
    }

    private List<Integer> StringToList(String number) {
        return number.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}
