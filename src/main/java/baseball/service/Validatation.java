package baseball.service;

public class Validatation {
    private static final int NUMBER_SIZE = 3;
    private static final int SIGNAL_SIZE = 1;

    public void validate(String num) {

        validateLength(num);
        validateRange(num);
        validateDuplicate(num);

    }

    public void validateForRestart(String sign) /*throws Exception*/ {

        validateSignLength(sign);
        validateSignRange(sign);

    }

    public void validateLength(String num)/* throws IllegalArgumentException */ {
        if (num.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException("세자리 숫자를 입력하시오");
        }
    }

    public void validateSignLength(String sign) /*throws Exception*/ {
        if (sign.length() != SIGNAL_SIZE) {
            throw new IllegalArgumentException("재시작: 1, 종료: 2");
        }
    }


    public boolean notNum(char number) {
        if (number >= '1' && number <= '9') {
            return false;
        }
        return true;
    }

    public boolean notSignal(char sign) {
        if (sign == '1' || sign == '2') {
            return false;
        }
        return true;
    }

    public void validateRange(String num) /*throws IllegalArgumentException*/ {
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (notNum(num.charAt(i))) {
                throw new IllegalArgumentException("각 자리에는 1~9 숫자만 입력하시오");
            }
        }
    }

    public void validateSignRange(String sign) /*throws Exception*/ {
        if (notSignal(sign.charAt(0))) {
            throw new IllegalArgumentException("재시작: 1, 종료: 2");
        }

    }


    public void validateDuplicate(String num) /*throws IllegalArgumentException*/ {
        int[] checkDuplicate = Converter.convertForDuplicate(num);
        for (int i = 0; i < checkDuplicate.length; i++) {
            if (checkDuplicate[i] > 1) {
                throw new IllegalArgumentException("중복된 숫자는 허용 되지 않습니다.");
            }
        }
    }


}
