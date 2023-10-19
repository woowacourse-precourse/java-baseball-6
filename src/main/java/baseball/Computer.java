package baseball;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> threeNumbers = new ArrayList<>();

    public void add(int num){
        threeNumbers.add(num);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "threeNumbers=" + threeNumbers +
                '}';
    }
}