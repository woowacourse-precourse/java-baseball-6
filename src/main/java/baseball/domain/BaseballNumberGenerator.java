package baseball.domain;

import java.util.List;

public interface BaseballNumberGenerator {
    List<Integer> generateBaseballNumber(int length) throws IllegalArgumentException;
}
