package baseball.domain;

import baseball.util.Constants;
import java.util.ArrayList;
import java.util.List;

public class BaseballNumber {
    private List<Integer> digits;

    public BaseballNumber() {
        this.digits = new ArrayList<>();
    }

    public void setNumber(String input) {
        digits.clear();

        if (input.length() != Constants.NUMBER_LENGTH) {
            throw new IllegalArgumentException("세 개의 숫자를 입력해야 합니다.");
        }

        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만 입력할 수 있습니다");
            }
            int digit = Character.getNumericValue(c);
            if (digits.contains(digit)) {
                throw new IllegalArgumentException("각 자리의 수는 서로 달라야 합니다.");
            }
            digits.add(digit);
        }
    }

    public int getDigit(int index) {
        return digits.get(index);
    }

    public int indexOf(int digit) {
        return digits.indexOf(digit);
    }
}
