package baseball.matcher;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberMatcher {

    private static final int NUMBER_LENGTH = 3;
    private static final String INPUT_NUMBER_REGEX = "[1-9]{3}";

    public List<Integer> checkInputNumber(String inputNumber) {
        if (inputNumber.length() != NUMBER_LENGTH || !inputNumber.matches(INPUT_NUMBER_REGEX)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 세 자리 숫자를 입력해주세요.");
        }

        List<Integer> inputNumbers = new ArrayList<>();
        for (char ch : inputNumber.toCharArray()) {
            inputNumbers.add(Character.getNumericValue(ch));
        }

        checkDuplicate(inputNumbers);

        return inputNumbers;
    }

    private void checkDuplicate(List<Integer> inputNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(inputNumbers);
        if (uniqueNumbers.size() != inputNumbers.size()) {
            throw new IllegalArgumentException("잘못된 입력입니다. 중복되지 않는 세 자리 숫자를 입력해주세요.");
        }
    }
}
