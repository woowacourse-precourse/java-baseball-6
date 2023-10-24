package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class User {

    // 유저 숫자 입력 받는 메서드
    public ArrayList<Integer> getUserNumber(ArrayList<Integer> userNumber) {

        String[] input = Console.readLine().split("");
        isValidInput(input);
        for (int i = 0; i < input.length; i++) {
            userNumber.add(Integer.parseInt(input[i]));
        }
        return userNumber;
    }

    // 입력값 유효성 검사
    public void isValidInput(String[] input) {
        checkLength(input);
        checkDuplication(input);
        checkValidNumber(input);
    }

    // 입력 값이 3자리인지 확인
    public void checkLength(String[] input) {
        if (input.length != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야합니다.");
        }
    }

    // 입력 값에 중복이 존재하는지 확인
    public void checkDuplication(String[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < i; j++) {
                if (input[i].equals(input[j])) {
                    throw new IllegalArgumentException("중복된 숫자 입니다.");
                }
            }
        }
    }

    // 입력 값에 1-9 외에 숫자가 존재하는지 확인
    public void checkValidNumber(String[] input) {
        for (int i = 0; i < input.length; i++) {
            if (!input[i].matches("^[1-9]$")) {
                throw new IllegalArgumentException("1-9 사이의 숫자만 입력해야합니다.");
            }
        }
    }
}
