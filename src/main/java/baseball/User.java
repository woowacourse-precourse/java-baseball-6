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

    // 유저 입력 값이 3자리인지 확인
    public void isValidInput(String[] input) {
        if (input.length != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야합니다.");
        }
    }
}
