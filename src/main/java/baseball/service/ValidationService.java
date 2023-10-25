package baseball.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class ValidationService {

    private static final List<String> NUMBER_LIST = new ArrayList<>(asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));

    public void validateGetNumbers(String[] numbersString) {
        validateLength(numbersString);
        validateTypeNumber(numbersString);
        validateDuplicate(numbersString);
    }

    public void validateStartNewGame(String select) {
        if (!select.equals("1") && !select.equals("2")) {
            throw new IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }

    private static void validateLength(String[] numbersString) {
        if (numbersString.length != 3) {
            throw new IllegalArgumentException("3자리를 입력해주세요.");
        }
    }

    private static void validateTypeNumber(String[] numbersString) {
        for (String number : numbersString) {
            if (!NUMBER_LIST.contains(number)) {
                throw new IllegalArgumentException("숫자를 입력해주세요.");
            }
        }
    }

    private static void validateDuplicate(String[] numbersString) {
        String[] removeDuplicateResult = Arrays.stream(numbersString).distinct().toArray(String[]::new);
        if (removeDuplicateResult.length != numbersString.length) {
            throw new IllegalArgumentException("서로 다른 수를 입력해주세요.");
        }
    }
}
