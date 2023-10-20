package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
        if (userInput.length() != 3)
            throw new IllegalArgumentException("입력한 값이 유효하지 않습니다. 세자리 자연수만 입력하십시오. 프로그램을 종료합니다.");
    }

    public void validateIsUserAnswerDigit(String userInput){
        for (int i = 0; i < 3; i++) {
            if (!Character.isDigit(userInput.charAt(i)))
                throw new IllegalArgumentException("입력한 값이 유효하지 않습니다. 세자리 자연수만 입력하십시오. 프로그램을 종료합니다.");
        }
    }

    public void validateUserAnswerDigitRange(List<Integer> userAnwserList){
        for (int i = 0; i < 3; i++) {
            if (userAnwserList.get(i) < 1 || userAnwserList.get(i) > 9)
                throw new IllegalArgumentException("입력한 값이 유효하지 않습니다. 세자리 자연수만 입력하십시오. 프로그램을 종료합니다.");
        }
    }

    public void validateIsDistinctDigits(List<Integer> userAnserList){
        HashSet<Integer> digitSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            digitSet.add(userAnserList.get(i));
        }
        if (digitSet.size() != userAnserList.size())
            throw new IllegalArgumentException("입력한 값이 유효하지 않습니다. 세자리 자연수만 입력하십시오. 프로그램을 종료합니다.");
    }

    public int validateRestartInput(String userInput){
        if (!userInput.equals("1") && !userInput.equals("2"))
            throw new IllegalArgumentException("입력한 값이 유효하지 않습니다. 1 혹은 2만 입력하십시오. 프로그램을 종료합니다.");

        return Integer.parseInt(userInput);
    }

    public List<Integer> toIntList(String userInput){
        List<Integer> userInputIntList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            userInputIntList.add((int) userInput.charAt(i) - '0');
        }
        return userInputIntList;
    }
}
