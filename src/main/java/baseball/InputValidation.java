package baseball;

public class InputValidation {
    public void validateRestartInput(String input) throws IllegalArgumentException {
        //한 글자인지 확인
        if (input.length() != 1) {
            throw new IllegalArgumentException("한 글자가 아닙니다");
        }

        //1-2 사이 숫자인지 확인
        if (!input.matches("[1-2]+")) {
            throw new IllegalArgumentException("1이나 2가 아닙니다");
        }
    }

    public void validateGameInput(String input) throws IllegalArgumentException {
        //세 글자인지 확인
        if (input.length() != 3) {
            throw new IllegalArgumentException("세 글자가 아닙니다");
        }

        //1-9 사이 숫자인지 확인
        if (!input.matches("[1-9]+")) {
            throw new IllegalArgumentException("1에서 9사이 숫자가 아닙니다");
        }

        //셋 다 다른 숫자인지 확인
        if (hasSameNumber(input)) {
            throw new IllegalArgumentException("중복되는 숫자가 존재합니다");
        }
    }

    private boolean hasSameNumber(String input) {
        int c1 = input.charAt(0);
        int c2 = input.charAt(1);
        int c3 = input.charAt(2);

        if (c1==c2 || c2==c3 || c3==c1) {
            return true;
        }

        return false;
    }
}
