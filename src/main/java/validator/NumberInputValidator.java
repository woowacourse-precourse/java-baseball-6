package validator;

public class NumberInputValidator {
    void vaildNumberOverThreeDigits(String balls) {
        if (balls.length() > 3) {
            throw new IllegalArgumentException("공의 개수가 3개 보다 많아요.");
        }
    }
}
