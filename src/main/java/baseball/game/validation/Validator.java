package baseball.game.validation;

import java.util.List;

/**
 * 표준입력으로 받은 입력값에 대한 유효성 검사 기능을 제공한다.
 * <p>1. 추측한 답(숫자 야구 3자리수)
 * <p>2. 재시작/종료를 선택하기 위한 입력값
 */
public class Validator {

    /**
     * 사용자가 입력한 답에 대해 유효성 검사를 진행한다.
     * <p>1. 길이가 3인가
     * <p>2. 각 자리가 '1'에서부터 '9'사이의 문자인가
     * <p>3. 각 자리가 서로 다른 문자인가
     * <p>하나라도 통과하지 못하면 IllegalArgumentException 예외가 발생한다.
     *
     * @param input 사용자가 입력한 답
     */
    public static void validateProposal(String input) {
        validateLength(input);
        validateRange(input);
        validateDifferentNumber(input);
    }

    /**
     * 재시작/종료 선택을 위한 입력값에 대해 유효성 검사를 진행한다.
     * <p>- 입력값이 "1" 또는 "2"인가
     * <p>통과하지 못하면 IllegalArgumentException 예외가 발생한다.
     *
     * @param input 재시작/종료 선택 입력값
     */
    public static void validateNewOrQuit(String input) {
        validateOneOrTwo(input);
    }


    private static void validateLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력값의 길이가 3이 아닙니다.");
        }
    }

    private static void validateRange(String input) {
        for (char number : input.toCharArray()) {
            if (number < '1' || number > '9') {
                throw new IllegalArgumentException("입력값의 범위가 맞지 않습니다.");
            }
        }
    }

    private static void validateDifferentNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt((i + 1) % 3)) {
                throw new IllegalArgumentException("서로 다른 3자리의 수가 아닙니다.");
            }
        }
    }

    private static void validateOneOrTwo(String input) {
        List<String> possibleNumber = List.of("1", "2");
        if (!possibleNumber.contains(input)) {
            throw new IllegalArgumentException("1(재시작) 또는 2(종료) 이외의 입력입니다.");
        }
    }

}
