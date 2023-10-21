package baseball;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumbers implements NumbersObjects {
    private List<Integer> computer = new ArrayList<>();

    public void add(int number) {
        computer.add(number);
    }

    public int get(int index) {
        return computer.get(index);
    }

    public void deleteAll() {
        computer.clear();
    }

    public int size() {
        return computer.size();
    }

    public boolean contains(int number) {
        return computer.contains(number);
    }

    public List<Integer> getList() {
        return computer;
    }
}
