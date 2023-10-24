package baseball.utils;

import java.util.HashSet;

import static baseball.utils.Constants.*;

/*
 주어진 입력이 올바른지 검증하는 클래스
 1. 입력의 길이가 3인지
 2. 입력에 중복은 없는지
 3. 입력의 각 문자가 숫자가 맞는지
 4. 입력의 각 숫자가 1 ~ 9에 해당하는지
 5. 재시작 구분 입력이 1 혹은 2가 맞는지
 */

public class InputValidator {

    private InputValidator() {
    }

    /*
    문자에 대한 검증을 하는 함수들
    문자가 숫자인지, 숫자면 1~9에 포함되는지 검증
    */
    public static void validateIsCharacterDigit(char answerChar) {
        if (!Character.isDigit(answerChar)) {
            throw new IllegalArgumentException("입력한 값이 유효하지 않습니다. 숫자만 입력하십시오. 프로그램을 종료합니다.");
        }
    }

    public static void validateDigitRange(int digit) {
        if (digit < USER_ANSWER_LOWER_LIMIT || digit > USER_ANSWER_UPPER_LIMIT) {
            throw new IllegalArgumentException("입력한 값이 유효하지 않습니다. 자연수만 입력하십시오. 프로그램을 종료합니다.");
        }
    }

    /*
    문자열에 대한 검증을 하는 함수들
    문자열의 길이, 중복 문자는 없는지, 재시작 입력이 올바른지 검증
    */
    public static void validateInputLength(String userInput, int length) {
        if (userInput.length() != length) {
            throw new IllegalArgumentException("입력한 값이 유효하지 않습니다. 입력 길이 " + length + "만큼 입력하십시오. 프로그램을 종료합니다.");
        }
    }

    public static void validateIsDistinct(String userAnswer) {
        HashSet<Character> digitSet = new HashSet<>();
        for (int i = 0; i < ANSWER_LENGTH; i++) {
            digitSet.add(userAnswer.charAt(i));
        }
        if (digitSet.size() != ANSWER_LENGTH) {
            throw new IllegalArgumentException("입력한 값이 유효하지 않습니다. 중복 없이 입력하십시오. 프로그램을 종료합니다.");
        }
    }

    public static void validateRestartInput(String userInput) {
        String restart = Integer.toString(WANNA_KEEP_PLAYING);
        String end = Integer.toString(WANNA_END);
        if (!userInput.equals(restart) && !userInput.equals(end)) {
            throw new IllegalArgumentException("입력한 값이 유효하지 않습니다. " + WANNA_KEEP_PLAYING
                    + "혹은 " + WANNA_END + "만 입력하십시오. 프로그램을 종료합니다.");
        }
    }

}
