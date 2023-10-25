package baseball.domain.strategy;

import java.util.List;

@FunctionalInterface
public interface BallNumbersGenerateStrategy {

    List<Integer> generate(int startInclusive, int endInclusive, int count);

}
