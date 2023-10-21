package baseball;

public class ExceptionHandling {
    public static void checkNumber(String something) throws IllegalArgumentException {
        for (int i = 0; i < something.length(); i++) {
            if (something.charAt(i) < '1' || something.charAt(i) > '9') {
                throw new IllegalArgumentException("해당 숫자가 아닙니다.");
            }
        }
    }

    public static void checkDuplication(String number) throws IllegalArgumentException {
        for (int i = 0; i < number.length() - 1; i++) {
            if (number.charAt(i) == number.charAt(i + 1)) {
                throw new IllegalArgumentException("값이 중복되었습니다.");
            }
        }
    }

    public static void checkNumberSize(String number) throws IllegalArgumentException {
        if (number.length() != FixedValue.input_number_size) {
            throw new IllegalArgumentException("3개의 숫자를 입력하지 않으셨습니다.");
        }
    }

    public static void restartOrEnd(String number) throws IllegalArgumentException {
        if (!number.equals(String.valueOf(FixedValue.restart_game)) && !number.equals(
                String.valueOf(FixedValue.end_game))) {
            throw new IllegalArgumentException("새로 시작하거나 종료하는 숫자가 아닙니다.");
        }
    }
}
