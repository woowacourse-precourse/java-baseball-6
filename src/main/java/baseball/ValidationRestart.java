package baseball;

class ValidationRestart extends Validation {
    private static final String restartErrorMessage = "1 또는 2로만 입력해주세요.";

    // 재시작에 대한 유효성 검사
    public static boolean isValid(String restart) {
        checkIsEmpty(restart, restartErrorMessage);
        checkIsNumber(restart, restartErrorMessage);
        return checkRestartAnswer(restart);
    }

    // 입력 유효성 검사: 1 또는 2가 아닌 수 입력 - restart
    private static boolean checkRestartAnswer(String restart) {
        int isRestart = Integer.parseInt(restart);
        if (isRestart != 1 && isRestart != 2) {
            throw new IllegalArgumentException(restartErrorMessage);
        }
        if (isRestart == 1) {
            Defender.reroll();
        }
        if (isRestart == 2) {
            System.out.println("프로그램을 종료합니다.");
            return true;
        }
        return false;
    }
}