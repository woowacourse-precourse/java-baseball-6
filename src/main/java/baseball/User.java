package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {
    private static final String ENTER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final int NUMBER_LEN = 3;
    public List<Integer> userAnswer = new ArrayList<Integer>();

    public void enterNumber() {
        System.out.print(ENTER_NUMBER_MESSAGE);
        String number = Console.readLine();
        setUserAnswer(number);
    }

    private void setUserAnswer(String number) {
        if (isValidInput(number)) {
            for (int i = 0; i < NUMBER_LEN; i++) {
                userAnswer.add(Character.getNumericValue(number.charAt(i)));
            }
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private boolean isValidInput(String number) {
        if (!checkValidLength(number)) {
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
}
