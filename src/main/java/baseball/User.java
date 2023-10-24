package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private static final String ENTER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final int NUMBER_LEN = 3;
    public List<Integer> userAnswer;

    public void enterNumber() {
        System.out.print(ENTER_NUMBER_MESSAGE);
        String number = Console.readLine();
        setUserAnswer(number);
    }

    private void setUserAnswer(String number) {
        userAnswer = new ArrayList<Integer>();
        if (isValidInput(number)) {
            for (int i = 0; i < NUMBER_LEN; i++) {
                userAnswer.add(Character.getNumericValue(number.charAt(i)));
            }
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private boolean isValidInput(String number) {
        if (!checkValidLength(number) || !checkDigit(number) || !checkDuplicatedNumber(number)) {
            return false;
        } else {
            return true;
        }
    }

    // 올바른 길이로 이루어져 있는지 검사하는 함수
    private boolean checkValidLength(String number) {
        if (number.length() != NUMBER_LEN) {
            return false;
        } else {
            return true;
        }
    }

    //1~9 사이의 숫자로만 이루어져 있는지 검사하는 함수
    private boolean checkDigit(String number) {
        for (int i = 0; i < NUMBER_LEN; i++) {
            if (number.charAt(i) < '1' || number.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    //중복된 숫자가 존재하는지 검사하는 함수
    private boolean checkDuplicatedNumber(String number) {

        List<Integer> numberList = new ArrayList<Integer>();

        for (int i = 0; i < NUMBER_LEN; i++) {
            numberList.add(Character.getNumericValue(number.charAt(i)));
        }

        Set<Integer> numberSet = new HashSet<Integer>(numberList);

        if (numberSet.size() != numberList.size()) {
            return false;
        }
        return true;
    }

}
