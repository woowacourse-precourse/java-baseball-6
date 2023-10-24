package baseball.utility;

public class ExceptionHandler {
    private static ExceptionHandler exceptionHandler = new ExceptionHandler();

    private ExceptionHandler() {
    }

    public static ExceptionHandler getExceptionHandler() {
        return exceptionHandler;
    }

    public void isSuitabledLength(String number) {
        if (number.length() != 3) {
            throw new IllegalStateException(Constant.WRONG_INPUT + Constant.PROGRAM_END);
        }
    }

    public void isNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) < '1' | number.charAt(i) > '9') {
                throw new IllegalStateException(Constant.WRONG_INPUT + Constant.PROGRAM_END);
            }
        }
    }
}
