package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserNumber {
    public String userNumber;

    public void UserNumber(String userNumber) {
        isDigitNum(userNumber);
        isCorrectThreeNum(userNumber);
        isNotDuplicate(userNumber);

        this.userNumber = userNumber;
    }
    public String getUserNumber() {
        return userNumber;
    }


    // 자연수인지 확인
    private void isDigitNum(String number) throws IllegalArgumentException {
        for(int i = 0; i < number.length(); i++) {
            if(number.charAt(i) < '1' || number.charAt(i) > '9') {
                throw new IllegalArgumentException("3자리 자연수를 입력해주세요");
            }
        }
    }

    // 3자리 수인지 확인
    private void isCorrectThreeNum(String number) throws IllegalArgumentException {
        if(number.length() != 3) {
            throw new IllegalArgumentException("입력값은 3자리 수 입니다");
        }
    }

    // 중복된 수 없는지 확인
    private void isNotDuplicate(String number) throws IllegalArgumentException {
        List<String> user = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            if (user.contains(String.valueOf(number.charAt(i)))) {
                throw new IllegalArgumentException(" 3자리 수는 중복될 수 없습니다");
            }
            user.add(String.valueOf(number.charAt(i)));
        }
    }

}
