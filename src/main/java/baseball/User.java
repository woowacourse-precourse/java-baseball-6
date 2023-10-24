package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class User {

    public ArrayList<Integer> getUserNumber(ArrayList<Integer> userNumber) {

        String[] input = Console.readLine().split("");
        isValidInput(input);
        for (int i = 0; i < input.length; i++) {
            userNumber.add(Integer.parseInt(input[i]));
        }
        return userNumber;
    }

    public void isValidInput(String[] input) {
        checkLength(input);
        checkDuplication(input);
        checkValidNumber(input);
    }

    public void checkLength(String[] input) {
        if (input.length != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야합니다.");
        }
    }

    public void checkDuplication(String[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < i; j++) {
                if (input[i].equals(input[j])) {
                    throw new IllegalArgumentException("중복된 숫자 입니다.");
                }
            }
        }
    }

    public void checkValidNumber(String[] input) {
        for (int i = 0; i < input.length; i++) {
            if (!input[i].matches("^[1-9]$")) {
                throw new IllegalArgumentException("1-9 사이의 숫자만 입력해야합니다.");
            }
        }
    }
}
