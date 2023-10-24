package baseball.validation;

public class Validator {

    public int checkValid(String checkNumber) {
        Integer number;
        try {
            number = Integer.parseInt(checkNumber);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해 주세요.", e);
        }

        if (checkNumber.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해 주세요.");
        }

        return number;
    }
}
