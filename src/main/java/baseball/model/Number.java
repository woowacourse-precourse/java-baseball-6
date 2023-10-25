package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private final List<Integer> number;

    public Number(List<Integer> number) {
        this.number = number;
    }

    public Number() {
        number = new ArrayList<>();
    }

    public void add(int num) {
        number.add(num);
    }

    public int size(){
        return number.size();
    }

    public boolean contains(int num) {
        return number.contains(num);
    }

    @Override
    public String toString() {
        return number.toString();
    }

    public Integer get(int index){
        return number.get(index);
    }

    public List<Integer> getList() {
        return this.number;
    }
}
