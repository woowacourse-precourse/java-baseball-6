package baseball.gameLogic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static baseball.models.Constants.*;

/*
 주어진 입력이 올바른지 검증하는 클래스, 서로 다른 3자리 자연수, 재시작/종료를 구분하는 수 모두 검사한다.
 */

public class InputValidator {

    public List<Integer> validateUserAnswer(String userInput){
        validateUserAnswerLength(userInput);
        validateIsUserAnswerDigit(userInput);

        List<Integer> userAnswerList= toIntList(userInput);

        validateUserAnswerDigitRange(userAnswerList);
        validateIsDistinctDigits(userAnswerList);

        return userAnswerList;
    }

    public void validateUserAnswerLength(String userInput){
        if (userInput.length() != ANSWER_LENGTH)
            throw new IllegalArgumentException("입력한 값이 유효하지 않습니다. 중복 없는 세자리 자연수만 입력하십시오. 프로그램을 종료합니다.");
    }

    public void validateIsUserAnswerDigit(String userInput){
        for (int i = 0; i < ANSWER_LENGTH; i++) {
            if (!Character.isDigit(userInput.charAt(i)))
                throw new IllegalArgumentException("입력한 값이 유효하지 않습니다. 중복 없는 세자리 자연수만 입력하십시오. 프로그램을 종료합니다.");
        }
    }

    public void validateUserAnswerDigitRange(List<Integer> userAnwserList){
        for (int i = 0; i < ANSWER_LENGTH; i++) {
            if (userAnwserList.get(i) < USER_ANSWER_LOWER_LIMIT || userAnwserList.get(i) > USER_ANSWER_UPPER_LIMIT)
                throw new IllegalArgumentException("입력한 값이 유효하지 않습니다. 중복 없는 세자리 자연수만 입력하십시오. 프로그램을 종료합니다.");
        }
    }

    public void validateIsDistinctDigits(List<Integer> userAnswerList){
        HashSet<Integer> digitSet = new HashSet<>();
        for (int i = 0; i < ANSWER_LENGTH; i++) {
            digitSet.add(userAnswerList.get(i));
        }
        if (digitSet.size() != ANSWER_LENGTH)
            throw new IllegalArgumentException("입력한 값이 유효하지 않습니다. 중복 없는 세자리 자연수만 입력하십시오. 프로그램을 종료합니다.");
    }

    public int validateRestartInput(String userInput){
        String restart = Integer.toString(WANNA_KEEP_PLAYING);
        String end = Integer.toString(END_NUMBER);
        if (!userInput.equals(restart) && !userInput.equals(end))
            throw new IllegalArgumentException("입력한 값이 유효하지 않습니다. 1 혹은 2만 입력하십시오. 프로그램을 종료합니다.");

        return Integer.parseInt(userInput);
    }

    public List<Integer> toIntList(String userInput){
        List<Integer> userInputIntList = new ArrayList<>();
        for (int i = 0; i < ANSWER_LENGTH; i++) {
            userInputIntList.add((int) userInput.charAt(i) - '0');
        }
        return userInputIntList;
    }
}
