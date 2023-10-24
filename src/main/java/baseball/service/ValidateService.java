package baseball.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidateService {

    private static final String THREE_NUMBER = "숫자 3자리로 입력하세요.";
    private static final String CHECK_NUMBER = "숫자를 입력하세요.";
    private static final String DUPLICATE_NUMBER = "서로 다른 3자리 숫자로 입력하세요.";

    private static final int INPUT_THREE_NUMBER = 3;

    /**
     * 유효성 검사 후 경고 출력
     */
    public List<Integer> validateNumber(String userInput) {
        if (!isThreeLength(userInput)) {
            throw new IllegalArgumentException(THREE_NUMBER);
        }
        if (!isDigit(userInput)) {
            throw new IllegalArgumentException(CHECK_NUMBER);
        }
        if (!isDuplicateNumber(userInput)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER);
        }
        return StringToIntList(userInput);
    }

    /**
     * 유효성 검사
     */
    // 3자리
    private boolean isThreeLength(String userInput) {
        return userInput.length() == INPUT_THREE_NUMBER;
    }

    // 숫자
    private boolean isDigit(String userInput) {
        return userInput.matches("-?\\d+");
    }

    // 서로 다른 숫자
    private boolean isDuplicateNumber(String userInput) {
        char[] inputChar = userInput.toCharArray();
        return inputChar[0] != inputChar[1] && inputChar[0] != inputChar[2] && inputChar[1] != inputChar[2];
    }

    /**
     * 사용자로부터 입력 받은 문자를 Integer List 로 변환
     */
    private List<Integer> StringToIntList(String userInput) {
        int[] convertedIntList = Arrays.stream(userInput.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        return Arrays.stream(convertedIntList).boxed().collect(Collectors.toList());
    }
}

