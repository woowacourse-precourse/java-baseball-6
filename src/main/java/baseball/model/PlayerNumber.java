package baseball.model;

import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class PlayerNumber {
    private final List<Integer> numbers;
    private static final int NUMBERS_SIZE = 3;
    
    private PlayerNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static PlayerNumber createPlayerNumber(String input) {
        validateNonNumeric(input);
        List<Integer> numbers = convertToIntegerList(input);
        validateNonZero(numbers);
        validateDuplicateAndSize(numbers);

        return new PlayerNumber(numbers);
    }

    /**
     * String 을 List<Integer> 로 변환
     */
    private static List<Integer> convertToIntegerList(String str) {
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            intList.add(Integer.parseInt(str.substring(i, i+1)));
        }
        return intList;
    }

    /**
     * 숫자가 아닌 값이 있는지 검증
     */
    private static void validateNonNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    /**
     * 0 이 있는지 검증
     */
    private static void validateNonZero(List<Integer> numbers) {
        if (numbers.contains(0)) {
            throw new IllegalArgumentException("0이 아닌 숫자 3개를 입력해주세요.");
        }
    }

    /**
     * 서로 다른 숫자 NUMBERS_SIZE 개 인지 검증
     */
    private static void validateDuplicateAndSize(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("서로 다른 숫자 3개를 입력해주세요.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
