package baseball;

public class InputValidate {

    private final String input;
    private static final int ORIGINCOUNT = 3;

    public InputValidate(String input) {
        this.input = input;
    }

    protected void validateInput() {
        validateNumber();
        validateSize();
        validateContainsZero();
        validateDuplicateNumber();
    }

    protected void validateSize() {
        if (input.length()!=ORIGINCOUNT) {
            throw new IllegalArgumentException("입력글자 수는 3글자 미만 또는 3글자 초과할 수 없습니다.");
        }
    }

    protected void validateNumber() {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("1부터 9까지의 수 중 서로 다른 3가지 수를 입력하셔야 합니다.");
        }
    }

    protected void validateContainsZero() {
        if (input.contains("0")) {
            throw new IllegalArgumentException("0을 입력할 수 없습니다. 1~9까지의 수 중 서로 다른 3가지 수를 입력해주세요");
        }
    }

    protected void validateDuplicateNumber() {
        if (input.charAt(0)==input.charAt(1) || input.charAt(1)==input.charAt(2) || input.charAt(2)==input.charAt(0)) {
            throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다. 1~9까지의 수 중 서로 다른 3가지 수를 입력해주세요");
        }
    }

}
