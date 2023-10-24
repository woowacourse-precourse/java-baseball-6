package baseball;

public class Validation {
    private static final String answerErrorMessage = "각 자리 수가 1~9이며, 서로 중복되지 않는 3자리 수를 입력해주세요.";
    private static final String restartErrorMessage = "1 또는 2로만 입력해주세요.";

    // 입력 유효성 검사 1. 빈 입력값 확인 - answer, restart
    private static void checkEmpty(String arg, String message) {
        if (arg.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    // 입력 유효성 검사 2. 숫자가 아닌 입력값(문자열) 확인 - answer, restart
    private static void checkNumber(String arg, String message) {
        try {
            Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(message);
        }
    }

    // 입력 유효성 검사 3. 0이 포함되어 있는가? - answer
    private static void checkIncludeZero(String arg) {
        for (int i = 0; i < 3; i++) {
            if (arg.charAt(i) == '0') {
                throw new IllegalArgumentException(answerErrorMessage);
            }
        }
    }

    // 입력 유효성 검사 4. 숫자이지만 3자리가 아닌 입력값 확인 - answer
    private static void checkLength(String arg) {
        if (arg.length() != 3) {
            throw new IllegalArgumentException(answerErrorMessage);
        }
    }

    // 입력 유효성 검사 5. 숫자이며, 3자리이지만 중복되는 입력값 확인 - answer
    private static void checkRepeat(String arg) {
        if (arg.charAt(0) == arg.charAt(1) || arg.charAt(0) == arg.charAt(2)
                || arg.charAt(1) == arg.charAt(2)) {
            throw new IllegalArgumentException(answerErrorMessage);
        }
    }

    // 입력 유효성 검사 6. 1 또는 2가 아닌 수 입력 - restart
    private static boolean checkRestart(int arg) {
        if (arg != 1 && arg != 2) {
            throw new IllegalArgumentException(restartErrorMessage);
        }
        if (arg == 1) {
            Defender.reroll();
        }
        if (arg == 2) {
            System.out.println("프로그램을 종료합니다.");
            return true;
        }
        return false;
    }


    // 제시한 답에 대한 유효성 검사
    public static void isValidAnswer(String arg) {
        checkEmpty(arg, answerErrorMessage);
        checkNumber(arg, answerErrorMessage);
        checkIncludeZero(arg);
        checkLength(arg);
        checkRepeat(arg);
    }

    // 재시작에 대한 유효성 검사
    public static boolean isValidAnswer2(String arg) {
        checkEmpty(arg, restartErrorMessage);
        checkNumber(arg, restartErrorMessage);

        int restart = Integer.parseInt(arg);
        return checkRestart(restart);
    }
}
