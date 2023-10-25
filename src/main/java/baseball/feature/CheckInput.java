package baseball.feature;

public class CheckInput {

    public void checkInput(String input) {
        isNotNumber(input);
        isNotFitLength(input);
        isNotDuplicated(input);
    }

    public void isNotNumber(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("1부터 9까지의 수를 입력하세요");
        }
    }

    public void isNotFitLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리의 수를 입력하세요");
        }
    }

    public void isNotDuplicated(String input) {
        if (input.chars().distinct().count() != 3) {
            throw new IllegalArgumentException("중복된 수가 존재합니다");
        }
    }

}
