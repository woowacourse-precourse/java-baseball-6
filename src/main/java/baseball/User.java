package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private List<Integer> userNumber;

    private static final int THREE_NUMBER = 3;

    public List<Integer> getUserNumber() {
        return userNumber;
    }

    public void inputUserNumber() {
        userNumber = new ArrayList<>();
        String number = Console.readLine();
        try {
            for (int i = 0; i < number.length(); i++) {
                userNumber.add(Integer.parseInt(Character.toString(number.charAt(i))));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("서로 다른 세자리 숫자를 입력하세요.");
        }
        validate(userNumber);
    }

    public void validate(List<Integer> userNumber) {
        checkDuplication(userNumber);
        checkLength(userNumber);

    }

    public void checkDuplication(List<Integer> userNumber) {
        Set<Integer> userNumber1 = new HashSet<>(userNumber);
        if (userNumber.size() != userNumber1.size()) {
            throw new IllegalArgumentException("서로 다른 세자리 숫자를 입력하세요.");
        }
    }

    public void checkLength(List<Integer> userNumber) {
        if (userNumber.size() != THREE_NUMBER) {
            throw new IllegalArgumentException("서로 다른 세자리 숫자를 입력하세요.");
        }
    }

}
