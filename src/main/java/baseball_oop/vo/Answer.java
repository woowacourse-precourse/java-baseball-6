package baseball_oop.vo;

import java.util.List;

public class Answer implements Comparable<Answer> {
    List<Integer> values;
    private final int LENGTH_LIMIT = 3;



    @Override
    public int compareTo(Answer o) {
        return 0;
    }
}
