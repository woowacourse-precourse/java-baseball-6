package baseball.Model;

public class Valid {
    private static final int BASEBALL_NUM_SIZE = 3;

    public static String checkValid(String userNumber) {
        if (userNumber.contains("0")) {
            throw new IllegalArgumentException("허가되지 않은 문자열");
        }
        if (userNumber.length() > BASEBALL_NUM_SIZE) {
            throw new IllegalArgumentException("초과 입력");
        }
        return userNumber;
    }
}
