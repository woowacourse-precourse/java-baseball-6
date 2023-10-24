package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Integer> number;

    public User() {
        this.number = new ArrayList<Integer>();
    }

    public void addNumber(int number) {
        this.number.add(number);
    }

    public int getBall(int index) {
        return number.get(index);
    }
}
