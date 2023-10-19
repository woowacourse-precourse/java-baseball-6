package baseball.api;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Computer {
    private static final int NUMBER_LENGTH = 3;

    public static String getResult() {
        Set<String> computer = init();
        return computer.stream().collect(Collectors.joining());
    }

    private static Set<String> init() {
        Set<String> computer = new HashSet<>();
        while (computer.size() < NUMBER_LENGTH) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            computer.add(randomNumber);
        }
        return computer;
    }

}
