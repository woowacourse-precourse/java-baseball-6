package baseball.util;

import java.util.List;

@FunctionalInterface
public interface BaseballNumberGenerator {
    List<Integer> generate();
}
