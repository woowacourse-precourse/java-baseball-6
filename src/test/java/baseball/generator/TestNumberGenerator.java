package baseball.generator;

import java.util.Queue;

public record TestNumberGenerator(Queue<Integer> numbers) implements NumberGenerator {

    @Override
    public Integer generate(Integer minNumber, Integer maxNumber) {
        return numbers.poll();
    }
}
