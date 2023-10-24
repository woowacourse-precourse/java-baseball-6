package baseball.model;

import baseball.view.InputView;

import java.util.HashSet;
import java.util.Set;

public class UserNumber {

    public static String userNumber() {
        String userNumber = InputView.getNum();
        correctUserNumber(userNumber);
        return userNumber;
    }

    public static void correctUserNumber(String number) throws IllegalArgumentException {
        if (number.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
        if (Integer.parseInt(number) <= 0) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < number.length(); i++) {
            set.add(number.charAt(i));
        }
        if (set.size() != number.length()) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }

}
