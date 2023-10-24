package baseball;

import java.util.HashSet;
import java.util.Set;

public class ExceptionUtil {
    static final int NUM = 3; //세 자리 숫자야구 게임

    public void checkException(String input) { //모든 오류 판단
        checkNoNumberException(input);
        checkCountException(input);
        checkDuplicateException(input);
    }

    public void checkNoNumberException(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) { //숫자가 아닌 경우 체크
                throw new IllegalArgumentException("숫자가 아닌 값을 입력하였습니다. 프로그램을 종료합니다.");
            }
        }
    }

    public void checkCountException(String input) {
        if (input.length() != NUM) { //입력값이 세 자리가 아닌 경우
            throw new IllegalArgumentException("세 자리 숫자가 아닌 값을 입력하였습니다. 프로그램을 종료합니다.");
        }
    }

    public void checkDuplicateException(String input) {
        Set<Character> charSet = new HashSet<>(); //set을 이용하여 중복값 체크
        for (char c : input.toCharArray()) {
            if (!charSet.add(c)) {
                throw new IllegalArgumentException("중복된 값을 입력하였습니다. 프로그램을 종료합니다.");
            }
        }
    }

    public void checkOneOrTwoException(String input) {
        if (input.equals("1") || input.equals("2")) {
            return;
        }
        throw new IllegalArgumentException("1이나 2가 아닌 숫자를 입력하였습니다. 프로그램을 종료합니다.");
    }
}
