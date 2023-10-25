package baseball.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.constant.Number.NUMBER_RANGE_START;
import static baseball.constant.Number.NUMBER_RANGE_END;
import static baseball.constant.Number.RESTART;
import static baseball.constant.Number.EXIT;

public class Validation {

    public void checkNumberLength(String userNumber, Integer length){
        if (userNumber.length() != length) throw new IllegalArgumentException("글자수가 다릅니다.");
    }

    public List<Integer> isAllDigits(String userNumbers){
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < userNumbers.length(); i++) {
            char ch = userNumbers.charAt(i);
            Integer digit = isDigit(ch);
            numbers.add(digit);
        }
        return numbers;
    }

    public Integer isDigit(char userNumber){
        if (!Character.isDigit(userNumber)) {
            throw new IllegalArgumentException("숫자가 아닌 문자가 있습니다.");
        }
        return Character.getNumericValue(userNumber);
    }

    public void isInRange(Integer number){
        if (number < NUMBER_RANGE_START || number > NUMBER_RANGE_END) {
            throw new IllegalArgumentException("숫자 범위를 벗어났습니다.");
        }
    }


    public void hasDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    public void isValidNumber(Integer retryNumber){
        if (retryNumber != RESTART && retryNumber != EXIT) {
            throw new IllegalArgumentException("1또는 2를 입력해야합니다.");
        }
    }
}
