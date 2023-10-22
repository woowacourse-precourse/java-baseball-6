package baseball.utils;

import java.util.HashSet;

import static baseball.utils.Constants.*;

/*
 주어진 입력이 올바른지 검증하는 클래스, 서로 다른 3자리 자연수, 재시작/종료를 구분하는 수 모두 검사한다.
 */

public final class InputValidator {

    private InputValidator(){
    }

    /*
    문자에 대한 검증을 하는 함수들
    문자가 Digit인지, Digit이면 1~9에 포함되는지 검증
    */
    public static int validateAnswerCharacter(char answerChar){
        int digit;

        validateIsCharacterDigit(answerChar);
        digit = Character.getNumericValue(answerChar);
        validateDigitRange(digit);

        return digit;

    }

    public static void validateIsCharacterDigit(char answerChar){
        if (!Character.isDigit(answerChar))
            throw new IllegalArgumentException("입력한 값이 유효하지 않습니다. 중복 없는 세자리 자연수만 입력하십시오. 프로그램을 종료합니다.");

    }

    public static void validateDigitRange(int digit){
        if (digit < USER_ANSWER_LOWER_LIMIT || digit > USER_ANSWER_UPPER_LIMIT)
            throw new IllegalArgumentException("입력한 값이 유효하지 않습니다. 중복 없는 세자리 자연수만 입력하십시오. 프로그램을 종료합니다.");
    }

    /*
    문자열에 대한 검증을 하는 함수들
    문자열의 길이, 중복 문자는 없는지, 재시작 입력이 올바른지 검증
    */

    public static void validateAnswerLength(int answerLength){
        if (answerLength != ANSWER_LENGTH)
            throw new IllegalArgumentException("입력한 값이 유효하지 않습니다. 중복 없는 세자리 자연수만 입력하십시오. 프로그램을 종료합니다.");
    }

    public static void validateIsDistinct(String userAnswer){
        HashSet<Character> digitSet = new HashSet<>();
        for (int i = 0; i < ANSWER_LENGTH; i++) {
            digitSet.add(userAnswer.charAt(i));
        }
        if (digitSet.size() != ANSWER_LENGTH)
            throw new IllegalArgumentException("입력한 값이 유효하지 않습니다. 중복 없는 세자리 자연수만 입력하십시오. 프로그램을 종료합니다.");
    }

    public static int validateRestartInput(String userInput){
        String restart = Integer.toString(WANNA_KEEP_PLAYING);
        String end = Integer.toString(WANNA_END);
        if (!userInput.equals(restart) && !userInput.equals(end))
            throw new IllegalArgumentException("입력한 값이 유효하지 않습니다. 1 혹은 2만 입력하십시오. 프로그램을 종료합니다.");

        return Integer.parseInt(userInput);
    }

}
