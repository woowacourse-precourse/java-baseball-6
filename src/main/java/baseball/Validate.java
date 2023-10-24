package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Validate {
    private List<Character> numberList;

    Validate() {

    }

    public void validateUser(String number) { // 입력받은 숫자가 이상하다면 예외를 던지는 메소드
        if (number.length() != 3 || checkZeroValue(number) == false) {
            throw new IllegalArgumentException();
        }
    }

    boolean checkZeroValue(String number) { // 입력받은 숫자에 gi이상한 값이 있는지 검사하는 메소드
        numberList = new ArrayList<>();

        for (int i = 0; i < number.length(); i++) {
            char userNumber = number.charAt(i);
            if (userNumber <= '0' || userNumber > '9') {
                return false;
            }
            if (numberList.contains(userNumber)) {
                return false;
            } else {
                numberList.add(userNumber);
            }
        }
        return true;
    }
}
