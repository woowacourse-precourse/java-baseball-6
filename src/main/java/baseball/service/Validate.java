package baseball.service;

public class Validate {
    private static final int NUMBER_SIZE = 3;

    public void validate(String num) throws Exception {
        validateLength(num);
        validateRange(num);
        validateDuplicate(num);
    }

    public void validateLength(String num) throws Exception {
        if (num.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException("세자리 숫자를 입력하시오");
        }
    }

    public boolean notNum(char number) {
        if (number >= '1' && number <= '9') {
            return false;
        }
        return true;
    }

    public void validateRange(String num) throws Exception {
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (notNum(num.charAt(i))) {
                throw new IllegalArgumentException("각 자리에는 1~9 숫자만 입력하시오");
            }
        }
    }

    public void validateDuplicate(String num) throws Exception {
        int[] checkDuplicate = Converter.convertForDuplicate(num);
        for (int i = 0; i < checkDuplicate.length; i++) {
            if (checkDuplicate[i] > 1) {
                throw new IllegalArgumentException("중복된 숫자는 허용 되지 않습니다.");
            }
        }
    }


}
