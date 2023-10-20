package baseball.domain;

import java.util.List;

public class UserNumber extends Number {

    private List<Integer> number;

    public void setNumber(List<Integer> number) {
        validateNumber(number);
        this.number = number;
    }

    public List<Integer> getNumber() {
        return number;
    }
}
