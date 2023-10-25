package baseball;

import baseball.random.Pick;
import baseball.random.RandomUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RandomTest {
    private static final RandomUtil randomUtil = Pick.getInstance();

    @Test
    public void randomTest() {
        for (int i = 0; i < 100; i++) {
            print(randomUtil.getBallNumber());
        }
    }

    private static void print(List<Integer> list) {
        for (Integer integer : list) {
            System.out.printf(integer + " ");
        }
        System.out.println();
    }
}
