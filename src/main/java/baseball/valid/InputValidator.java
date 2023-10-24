package baseball.valid;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public void isMatch3Size(String userNum) {
        if (userNum.length() != 3) { // 3자리수가 아닌경우,
            throw new IllegalArgumentException();
        }
    }

    public void isMatchNumber(String userNum) {
        final String REGEX = "[1-9]+";
        if (!userNum.matches(REGEX)){
            throw new IllegalArgumentException("1-9로 만들어진 숫자가 아닙니다.");
        }
    }

    public void isDifferentNum(String userNum) {
        if (!checkDifferentNum(userNum)) {
            throw new IllegalArgumentException("유저가 입력한 숫자는 서로 다른 3자리 숫자여야 합니다.");
        }
    }

    private boolean checkDifferentNum(String userNum) {
        Set<Character> charSet = new HashSet<>();
        for (char c : userNum.toCharArray()) {
            charSet.add(c);
        }
        return charSet.size() == userNum.length();
    }

    public void isMatch1Size(String userNum) {
        if (userNum.length() != 1) {
            throw new IllegalArgumentException("한자리 숫자가 아닙니다.");
        }
    }

    public void isMatchAgainNumber(String userNum) {
        final String REGEX = "[1-2]+";
        if (!userNum.matches(REGEX)){
            throw new IllegalArgumentException("1-2로 만들어진 숫자가 아닙니다.");
        }
    }
}
