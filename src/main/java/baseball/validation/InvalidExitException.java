package baseball.validation;

public class InvalidExitException {
    private static final String EXIT_CHOICE_REGEX = "[1-2]+";
    private static final String NUMBER_REGEX = "[1-9]+";
    public void checkValidChoice(String choice) {
        isOverTwo(choice);
//        isNumeric(choice);
    }
    public void isOverTwo(String pickNumber) {
        if(pickNumber.matches(EXIT_CHOICE_REGEX)) {
            throw new IllegalArgumentException("1과 2만 입력해주세요.");
        }
    }
    public void isNumeric(String pickNumber) {
        if(pickNumber.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }
}
