package baseball;

import java.util.List;

public class FixedAnswerGenerator implements AnswerGenerator {
    @Override
    public List<Integer> generate() {
        return List.of(7, 1, 3);
    }
}
