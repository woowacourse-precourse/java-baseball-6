package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class UserNumberRepository  {
    private static List<Integer> numbers = new ArrayList<>();
    private static final UserNumberRepository instance = new UserNumberRepository();

    public Integer size(){
        return numbers.size();
    }

    public boolean contain(int pickNumber) {
        return numbers.contains(pickNumber);
    }

    public Integer findById(int index) {
        return numbers.get(index);
    }

    public void addValue(int pickNumber) {
        numbers.add(pickNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static UserNumberRepository getInstance() {
        return instance;
    }

    public void clear() {
        numbers.clear();
    }
}
