package baseball.domain;

import java.util.List;

public class AnswerNumber extends Number {
    private final List<Integer> number;

    public AnswerNumber(List<Integer> number) {
        validateNumber(number);
        this.number = number;
    }

    public List<Integer> getNumber() {
        return number;
    }
}
