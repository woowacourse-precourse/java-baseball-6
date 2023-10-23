package baseball.model;

public class UserRestartNumber {
    String userRestart;

    public UserRestartNumber(String userRestart){
        checkTypeNumber(userRestart);
        checkRestartNumber(userRestart);
        this.userRestart = userRestart;
    }

    public String getRestartNumber() {return userRestart;}

    public static void checkTypeNumber(String userRestart) throws IllegalArgumentException {
        if (!userRestart.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }
    public static void checkRestartNumber(String userRestart) throws IllegalArgumentException {
        if (!userRestart.equals("1") && !userRestart.equals("2")) {
            throw new IllegalArgumentException("1 또는 2만 입력해주세요.");
        }
    }
}
