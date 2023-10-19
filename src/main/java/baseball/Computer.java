package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Computer {

    private final String numbers;

    public Computer() {
        numbers = getRandomNumbers();
    }

    private String getRandomNumbers() {
        Set<Integer> set = new HashSet<>();

        while (set.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            set.add(randomNumber);
        }

        return setToString(set);
    }

    private String setToString(Set<Integer> set) {
        StringBuilder sb = new StringBuilder();
        for (int num : set) {
            sb.append(num);
        }
        return sb.toString();
    }
}
