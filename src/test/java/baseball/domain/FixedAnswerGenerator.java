package baseball.domain;

import java.util.List;

public class FixedAnswerGenerator implements AnswerGenerator {
    @Override
    public Answer generate() {
        return new Answer(List.of(7, 1, 3));
    }
}
