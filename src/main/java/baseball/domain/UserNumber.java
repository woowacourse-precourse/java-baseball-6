package baseball.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * user 입력한 값
 */
public class UserNumber {
    private List<Integer> userNumber;

    public UserNumber(String userNumber) {
        List<Integer> number = new ArrayList<>();
        isLengthMatch(userNumber);
        isNumber(userNumber);
        isPlus(userNumber);

        for (int i = 0; i<userNumber.length(); i++) {
            char digitChar = userNumber.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            if (number.contains(digit)) {
                throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
            }
            number.add(digit);
        }
        this.userNumber = number;
    }

    public List<Integer> getUserNumber() {
        return userNumber;
    }

    /**
     * 자리 수 3자리 일치하지 않을 경우 에러
     * @param userNumber
     * @throws IllegalArgumentException
     */
    private void isLengthMatch(String userNumber) {
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException("입력하신 값의 자릿 수가 일치하지 않습니다.");
        }
    }

    /**
     * 숫자가 아닐 경우 에러
     * @param userNumber
     * @throws IllegalArgumentException
     */
    private void isNumber(String userNumber) {
        try {
            Integer.parseInt(userNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력하신 값이 숫자가 아닙니다.");
        }
    }

    private void isPlus(String userNumber) {
        int num = Integer.parseInt(userNumber);
        if (num < 0) {
            throw new IllegalArgumentException("입력하신 값이 자연수가 아닙니다.");
        }
    }


}
