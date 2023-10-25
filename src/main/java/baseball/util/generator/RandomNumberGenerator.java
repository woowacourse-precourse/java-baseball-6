package baseball.util.generator;

import java.util.List;

public interface RandomNumberGenerator {
    List<Integer> pickUniqueRandomNumber(int numberDigits, int startInclusive, int endInclusive);
}
