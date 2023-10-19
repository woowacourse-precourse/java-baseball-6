package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private List<Integer> userNumber;

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
            System.out.println("서로 다른 세자리 숫자를 입력하세요.");
            throw new IllegalArgumentException();
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
            System.out.println("서로 다른 세자리 숫자를 입력하세요.");
            throw new IllegalArgumentException();
        }
    }

    public void checkLength(List<Integer> userNumber) {
        if (userNumber.size() != 3) {
            System.out.println("서로 다른 세자리 숫자를 입력하세요.");
            throw new IllegalArgumentException();
        }
    }

}
