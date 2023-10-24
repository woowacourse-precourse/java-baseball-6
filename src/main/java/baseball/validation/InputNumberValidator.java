package baseball.validation;

import java.util.HashSet;
import java.util.Set;

/*
 * 플레이어가 입력한 숫자를 검증하는 클래스
 * */
public class InputNumberValidator {

    private static final String RESTART = "1";
    private static final String STOP = "2";
    private static final String REGEX = "[0-9]+";
    private static final Integer NUMBER_SIZE = 3;

    /*
     * 플레이어의 입력값(String) 전체 검증 메서드
     * @Param userInput 플레이어의 숫자
     * */
    public static boolean validateInputNumber(String userInput) {
        validateInputSize(userInput);
        validateInputType(userInput);
        validateInputDuplication(userInput);

        return true;
    }

    /*
     * 플레이어의 입력값이 3자리 수인지 확인
     * @Param userInput 플레이어의 숫자
     * */
    private static void validateInputSize(String userInput) {
        if (userInput.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    /*
     * 플레이어의 입력값이 숫자인지 확인
     * @Param userInput 플레이어의 숫자
     * */
    private static void validateInputType(String userInput) {
        if (!userInput.matches(REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    /*
     * 플레이어의 입력값이 중복인지 확인
     * @Param userInput 플레이어의 숫자
     * */
    private static void validateInputDuplication(String userInput) {
        Set<Character> duplicateCheckSet = new HashSet<>();
        for (char c : userInput.toCharArray()) {
            duplicateCheckSet.add(c);
        }

        if (duplicateCheckSet.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    /*
     * 게임 재시작 물음 시 플레이어의 입력값 검증 메서드
     * @Param userInput 플레이어의 숫자
     * */
    public static void validateGameStateInput(String userInput) {
        if (!(userInput.equals(RESTART) || userInput.equals(STOP))) {
            throw new IllegalArgumentException();
        }
    }
}
