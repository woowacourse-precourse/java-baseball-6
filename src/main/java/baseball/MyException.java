package baseball;

import java.util.HashSet;
import java.util.Set;

public class MyException {
    private static final MyException myException = new MyException();

    private MyException() {
    }

    public static MyException getMyException() {
        return myException;
    }

    // 게임 중 예외 검사
    public String checkAnswer(String inputValue) {
        Set<Character> set = new HashSet<>();
        // 3자리수가 아닌 경우
        checkLength(inputValue.length());
        // 문자나 중복 숫자가 들어올 경우
        for (int i = 0; i < inputValue.length(); i++) {
            if (!Character.isDigit(inputValue.charAt(i))) throw new IllegalArgumentException();
            set.add(inputValue.charAt(i));
        }
        checkLength(set.size());
        return inputValue;
    }

    // 게임 종료 후 예외 검사
    public int checkFinishAnswer(String inputValue) {
        if (inputValue.equals("1") || inputValue.equals("2"))
            return Integer.parseInt(inputValue);
        else
            throw new IllegalArgumentException();
    }

    // 공통부분 추출
    private static void checkLength(int length) {
        if (length != 3) throw new IllegalArgumentException();
    }

}
