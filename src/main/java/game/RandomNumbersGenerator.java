package game;

import camp.nextstep.edu.missionutils.Randoms;
import constants.NumberConstants;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomNumbersGenerator {

    private static Set<Integer> set;

    public static String getRandomNumbers() {
        initSet();
        fillSet();
        return getStringNumbers();
    }


    private static void initSet() {
        set = new HashSet<>();
    }

    private static void fillSet() {
        while (isFull()) {
            set.add(pickRandomNumber());
        }
    }

    private static int pickRandomNumber() {
        return Randoms.pickNumberInRange(NumberConstants.MIN_NUMBER, NumberConstants.MAX_NUMBER);
    }

    private static boolean isFull() {
        return set.size() < NumberConstants.MAX_BALL_SIZE;
    }

    private static String getStringNumbers() {
        return set.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }

}
