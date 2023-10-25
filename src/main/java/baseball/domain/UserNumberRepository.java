package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class UserNumberRepository implements NumberRepository {
    private static List<Integer> numbers = new ArrayList<>();
    private static final UserNumberRepository instance = new UserNumberRepository();

    public static UserNumberRepository getInstance() {
        return instance;
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

    public void clear() {
        numbers.clear();
    }
}
