package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator{
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 9;
    private final static int MAX_SIZE = 3;
    private final static String NUMBER_EXCEPTION = "1에서 9사이의 '숫자'를 입력하세요.";
    private final static String SIZE_EXCEPTION = "입력 숫자는 세자리 입니다.";
    private final static String DUPLICATE_EXCEPTION = "중복된 값이 존재합니다.";
    private final static String GAME_END_EXCEPTION = "1 또는 2의 값을 입력하세요.";
    private final static String EMPTY_EXCEPTION = "비어있지 않은 값을 입력하세요";


    public Validator() {}

    public void checkValidNumbers(List<Integer> numbers) {
        if (!isValidNumbers(numbers)) {
            throw new IllegalArgumentException(NUMBER_EXCEPTION);
        }
        if (!isValidSize(numbers)) {
            throw new IllegalArgumentException(SIZE_EXCEPTION);
        }
        if (!isValidDuplicate(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION);
        }
    }

    public void checkValidString(String stringNumbers) {
        if (!isNotEmpty(stringNumbers)) {
             throw new IllegalArgumentException(EMPTY_EXCEPTION);
        }
        List<Integer> numbers = stringNumbers.chars()
                .map(number -> number-48)
                .boxed()
                .toList();
        if (!isValidNumbers(numbers)) {
            throw new IllegalArgumentException(NUMBER_EXCEPTION);
        }
    }

    private boolean isNotEmpty(String stringNumbers) {
        return !stringNumbers.isEmpty();
    }

    public void checkValidGameEnd(String gameEndFlag) {
        if (!(gameEndFlag.equals("1") || gameEndFlag.equals("2"))) {
            throw new IllegalStateException(GAME_END_EXCEPTION);
        }
    }

    private boolean isValidNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            if(!isValidNumber(number)) return false;
        }
        return true;
    }

    private boolean isValidNumber(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }

    private boolean isValidSize(List<Integer> numbers) {
        return numbers.size() == MAX_SIZE;
    }

    private boolean isValidDuplicate(List<Integer> numbers) {
        Set<Integer> checkDuplicateSet = new HashSet<>(numbers);
        return numbers.size() == checkDuplicateSet.size();
    }
}
