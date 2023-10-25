package baseball.domain.strategy;

@FunctionalInterface
public interface BallNumbersGenerateStrategy {

    String generate(int startInclusive, int endInclusive, int count);

}
