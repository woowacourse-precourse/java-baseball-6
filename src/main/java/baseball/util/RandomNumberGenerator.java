package baseball.util;

import java.util.List;

public interface RandomNumberGenerator {
    int generateRandomNumber(int min, int max);

    List<Integer> createUniqueNumbers(int size);
}
