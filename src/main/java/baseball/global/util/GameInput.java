package baseball.global.util;

public class GameInput {


    public static int validateMenu(String s) {
        if (s.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어 있습니다.");
        }
        if (!s.equals("1") && !s.equals("2")) {
            throw new IllegalArgumentException("1(재시작) 또는 2(종료)만 입력해주세요.");
        }
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1(재시작) 또는 2(종료)만 입력해주세요.");
        }
    }

    public static void validateNum(int order) {
        if (order == 0) {
            throw new IllegalArgumentException("0은 숫자에 포함할 수 없습니다.");
        }
    }
}
