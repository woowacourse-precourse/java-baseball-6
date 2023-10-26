package baseball.domain.generator;

import java.util.List;

@FunctionalInterface
public interface BaseballNumbersGenerator {
    List<Integer> generate();
}
