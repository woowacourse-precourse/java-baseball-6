package baseball.global.util;

/**
 * 사용자가 입력받는 값에 대한 처리만을 담당하는 클래스
 */
public class GameInput {


    public static int validateMenu(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어 있습니다.");
        }
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("1(재시작) 또는 2(종료)만 입력해주세요.");
        }
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1(재시작) 또는 2(종료)만 입력해주세요.");
        }
    }

    public static void validateNum(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어 있습니다.");
        }

        if (input.length() != 3) {
            throw new IllegalArgumentException("세 자리 수를 입력해야 합니다.");
        }

        for (int i = 0; i < input.length(); i++) {

            int order;
            try {
                order = Integer.parseInt(String.valueOf(input.charAt(i)));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
            }

            if (order == 0) {
                throw new IllegalArgumentException("0은 숫자에 포함할 수 없습니다.");
            }

        }
    }
}
