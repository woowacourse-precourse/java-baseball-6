package baseball.validator;

public class Validator {

    public int parseValidatedInt(String str) {
        int result = 0;
        try {
            result = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
        return result;
    }

    public void validateCiphers(int value, int ciphers) {
        // 세 자리면 100(10^2)으로 나누고, 한 자리면 1(10^0)으로 나눈다.
        int divideBy = (int) Math.pow(10, (ciphers - 1));
        int divisionResult = value / divideBy;
        if (divisionResult <= 0 || divisionResult >= 10) {
            throw new IllegalArgumentException("자릿수가 맞지 않습니다.");
        }
    }
}
