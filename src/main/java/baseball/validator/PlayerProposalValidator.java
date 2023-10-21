package baseball.validator;

//TODO 싱글톤 패턴 변경?
public class PlayerProposalValidator implements Validator {

    @Override
    public void validate(String input) {
        validateLength(input);
        validateNumberRange(input);
        validateDifferentNumber(input);
    }

    private void validateLength(String input) {
        if (input.length() != 3) throw new IllegalArgumentException("입력값의 길이가 3이 아닙니다.");
    }

    private void validateNumberRange(String input) {
        for (char number : input.toCharArray()) {
            if (number < '1' || number>'9') throw new IllegalArgumentException("입력값의 숫자 범위가 맞지 않습니다.");
        }
    }

    private void validateDifferentNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt((i + 1) % 3)) throw new IllegalArgumentException("서로 다른 3자리의 수가 아닙니다.");
        }
    }
}
