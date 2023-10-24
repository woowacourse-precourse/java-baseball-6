package baseball.Model;

public class Valid {
    private static final int BASEBALL_NUM_SIZE = 3;
    private static final String GAME_RESTART = "1";
    private static final String GAME_OVER = "2";


    public static String startValid(String userNumber) {
        if (userNumber.contains("0")) {
            throw new IllegalArgumentException("허가되지 않은 문자열");
        }
        if (userNumber.length() != BASEBALL_NUM_SIZE) {
            throw new IllegalArgumentException("입력 수 오류");
        }
        return userNumber;
    }

    public static boolean restartValid(String userNumber) {
        if (userNumber.equals(GAME_RESTART)) {
            return true;
        }
        if (userNumber.equals(GAME_OVER)) {
            return false;
        }
        throw new IllegalArgumentException("허가되지 않은 문자열");
    }
}
