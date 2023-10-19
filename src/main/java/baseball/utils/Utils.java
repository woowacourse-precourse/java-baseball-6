package baseball.utils;

public class Utils {

    public static void validateStringOneorTwo(String input) {
        if(input.equals("1") || input.equals("2")) {
            return;
        }
        throw new IllegalArgumentException("유효하지 않은 값을 입력하여 게임을 종료하겠습니다.");
    }
}
