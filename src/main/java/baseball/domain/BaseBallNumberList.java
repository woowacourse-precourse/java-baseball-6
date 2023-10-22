package baseball.domain;

import java.util.List;

public class BaseBallNumberList {

    private BaseBallNumberList(List<Integer> list) {
        if (list.size() != 3) {
            throw new IllegalArgumentException("숫자를 3개를 입력해주세요");
        }
    }

    public static BaseBallNumberList from(String numericInput) {
        validateNumericInput(numericInput);

        return new BaseBallNumberList(getList(numericInput));
    }

    public static BaseBallNumberList from(List<Integer> baseBallNumbers) {
        return new BaseBallNumberList(baseBallNumbers);
    }

    private static List<Integer> getList(String numericString) {
        return numericString
                .chars()
                .mapToObj(Character::getNumericValue)
                .toList();
    }

    private static void validateNumericInput(String numericString) {
        if (!numericString.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자만을 입력하셔야 합니다.");
        }
    }
}
