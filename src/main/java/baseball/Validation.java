package baseball;

public class Validation {

    /**
     * 사용자가 입력한 예상 숫자가 형식에 맞는지 확인
     *
     * @param playerNumber
     */
    public static void validateNumber(String playerNumber) {
        if (playerNumber.contains("0")) {
            throw new IllegalArgumentException("각 자리 숫자는 1~9여야 합니다.");
        }

        if (playerNumber.length() != 3) {
            throw new IllegalArgumentException("세 자리 숫자를 입력해주세요.");
        }

        try {
            Integer.parseInt(playerNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }

        char a = playerNumber.charAt(0);
        char b = playerNumber.charAt(1);
        char c = playerNumber.charAt(2);
        if (a == b || b == c || a == c) {
            throw new IllegalArgumentException("각 자리의 수는 서로 달라야 합니다.");
        }
    }

    /**
     * 게임 더 할건지 말건지 물어볼 때 사용자가 1, 2를 잘 입력했는지 체크. 1 입력시 true 반환, 2 입력시 false 반환, 나머지 입력시 IllegalArgumentException 던집
     *
     * @param input
     * @return
     */
    public static boolean isValidKey(String input) {

        int restart;
        try {
            restart = Integer.parseInt(input); //"1", "2"를 int로 변환 시도
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 키를 입력했습니다. 프로그램을 종료합니다.");
        }

        if (restart == 1) {
            return true;
        } else if (restart == 2) {
            return false;
        } else {
            throw new IllegalArgumentException("잘못된 키를 입력했습니다. 프로그램을 종료합니다.");
        }
    }

}
