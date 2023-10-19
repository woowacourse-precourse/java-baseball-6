package baseball.utils;

import java.util.HashMap;
import java.util.Map;

public class Randoms {

    public static String generateBaseballNumbers() {
        Map<Integer, Boolean> checkPoints = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        do {
            int random = rangeBy(1, 9);
            if (checkPoints.containsKey(random)) {
                continue;
            }
            checkPoints.put(random, true);
            stringBuilder.append(random);
        } while (stringBuilder.length() < 3);
        return stringBuilder.toString();
    }

    public static int rangeBy(int min, int max) {
        return (int) (Math.random() * max) + min;
    }
}
