package baseball;

import java.util.ArrayList;
import java.util.List;

public class Number {
    List<Integer> numbers = new ArrayList<>();
    int length;

    public Number(int n) {
        length = n;
    }

    public ArrayList<Integer> getNumbers() { return (ArrayList<Integer>) numbers; }
}
