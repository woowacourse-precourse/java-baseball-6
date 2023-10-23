package baseball.model;

public class UserRestartNumber {
    String userRestart;

    public UserRestartNumber(String userRestart){
        checkTypeNumber(userRestart);
        checkRestartNumber(userRestart);
        this.userRestart = userRestart;
    }

    public String getRestartNumber() {return userRestart;}

    //    숫자 타입인지 확인 후 예외 처리
    public static void checkTypeNumber(String userRestart) throws IllegalArgumentException {
        if (!userRestart.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    //    숫자가 1 또는 2인지 학인 후 예외 처리
    public static void checkRestartNumber(String userRestart) throws IllegalArgumentException {
        if (!userRestart.equals("1") && !userRestart.equals("2")) {
            throw new IllegalArgumentException("1 또는 2만 입력해주세요.");
        }
    }
}
