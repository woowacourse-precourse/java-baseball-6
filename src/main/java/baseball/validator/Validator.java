package baseball.validator;

public class Validator {
    public void userInput(String input) {
        boolean[] duplicateCheck = new boolean[10];

        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }

        try {
            Integer castTest = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 문자는 입력할 수 없습니다.");
        }

        for (int i = 0; i < 3; i++) {
            int intValue = input.charAt(i) - '0';

            if (intValue == 0) {
                throw new IllegalArgumentException("1~9 사이의 숫자를 입력해주세요.");
            }
            if (duplicateCheck[intValue]) {
                throw new IllegalArgumentException("입력 내에 중복된 숫자가 존재합니다.");
            }
            duplicateCheck[intValue] = true;
        }
    }

    public void systemInput(String input) {
        if (!"1".equals(input) && !"2".equals(input)) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }
}
