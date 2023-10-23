package baseball.domain.number;

import java.util.List;

public class AnswerNumber extends GameNumber{

    private final List<Integer> number;

    public AnswerNumber(List<Integer> number) {
        super(number);
        this.number = number;
    }

    public boolean isContain(int indexNumber) {
        return number.contains(indexNumber);
    }

    public boolean isInPlace(int index, int indexNumber) {
        return this.number.get(index).equals(indexNumber);
    }
}
