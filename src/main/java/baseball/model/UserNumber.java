package baseball.model;

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

    public List<Integer> getNumber() {
        return number;
    }

    private void validate(String number) {
        if(isEmpty(number)|| !isDigit(number)){
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
        else if(!isThreeDigit(number)){
            throw new IllegalArgumentException("세자리 숫자를 입력해주세요");
        }
        else if(!isInRange(StringToList(number))){
            throw new IllegalArgumentException("각자리의 숫자가 1부터 9사이의 숫자로 이루어져야 합니다");
        }
        else if(!isDistinct(StringToList(number))){
            throw new IllegalArgumentException("중복된 숫자가 존재하지 않아야 합니다");
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

    private boolean isInRange(List<Integer> numberList) {
        return numberList.stream()
                .allMatch(num -> num>=MINIMUM_NUM_IN_RANGE && num<=MAXIMUM_NUM_IN_RANGE);
    }

    private boolean isDistinct(List<Integer> numberList) {
        return numberList.stream()
                .distinct()
                .count() == LIST_SIZE;
    }

    private List<Integer> StringToList(String number) {
        return number.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}
