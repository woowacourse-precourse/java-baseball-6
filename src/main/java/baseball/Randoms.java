package baseball;

import java.util.Random;

public class Randoms {
    private static final Random RANDOM = new Random();

    public static int pickNumberInRange(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }
}
