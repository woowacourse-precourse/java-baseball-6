package baseball.model;

import java.util.*;


public class PlayerNumber {
    private final List<Integer> numbers;
    private static final int NUMBERS_SIZE = 3;

    private PlayerNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static PlayerNumber create(String input) {
        validateNonNumeric(input);
        List<Integer> numbers = convertToIntegerList(input);
        validateNonZero(numbers);
        validateDuplicate(numbers);
        validateSize(numbers);

        return new PlayerNumber(numbers);
    }

    private static List<Integer> convertToIntegerList(String str) {
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            intList.add(Integer.parseInt(str.substring(i, i+1)));
        }
        return intList;
    }

    private static void validateNonNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private static void validateNonZero(List<Integer> numbers) {
        if (numbers.contains(0)) {
            throw new IllegalArgumentException("[ERROR] 0이 아닌 숫자 3개를 입력해주세요.");
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 서로 다른 숫자 3개를 입력해주세요.");
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 서로 다른 숫자 3개를 입력해주세요.");
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
