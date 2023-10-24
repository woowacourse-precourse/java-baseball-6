package baseball.domain.number;

import java.util.List;

public class UserNumber extends GameNumber {

    private final List<Integer> number;

    public UserNumber(List<Integer> number) {
        super(number);
        this.number = number;
    }

    public int getNumberOfIndex(int index) {
        return this.number.get(index);
    }

    public List<Integer> getNumber() {
        return number;
    }
}
