package baseball.Util;

public class Validator {

    public Integer validateRange(String input) {
        Integer number = isNumeric(input);
        if (1 > number || number > 9) {
            throw new IllegalArgumentException("입력한 값이 범위가 1에서 9 사이가 아닙니다.");
        }
        return number;
    }

    private Integer isNumeric(String input) {
        try {
            Integer number = Integer.parseInt(input);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력한 값이 정수가 아닙니다.");
        }
    }
}
