package baseball;

import baseball.utils.RandomUtils;
import org.junit.jupiter.api.Test;

public class RandomUtilTest {
    @Test
    void checkUtils() {
        RandomUtils utils = new RandomUtils();
        int[] randomNumbers = utils.getRandomNumbers(3, 1, 9);
        for (int i : randomNumbers) {
            System.out.println(i);
        }
    }
    @Test
    void mi
}
