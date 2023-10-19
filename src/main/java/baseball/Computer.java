package baseball;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    // Computer가 어떤 숫자를 가지고 있는지 모르게 하기 위해
    private final List<Integer> threeNumbers = new ArrayList<>();

    public void add(int num){
        threeNumbers.add(num);
    }

    public boolean contains(int num){
        return threeNumbers.contains(num);
    }

    public int size(){
        return threeNumbers.size();
    }
    @Override
    public String toString() {
        return "Computer{" +
                "threeNumbers=" + threeNumbers +
                '}';
    }
}