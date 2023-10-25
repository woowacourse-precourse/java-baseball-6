package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class AnswerNumberRepository implements NumberRepository {
    private static List<Integer> numbers = new ArrayList<>();
    private static final AnswerNumberRepository instance = new AnswerNumberRepository();

    public static AnswerNumberRepository getInstance() {
        return instance;
    }

    public Integer size() {
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

    public void clear() {
        numbers.clear();
    }

}
