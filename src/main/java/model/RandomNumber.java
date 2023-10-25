package model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomNumber {
    private final int MIN_RANDOM_NUMBER = 1;
    private final int MAX_RANDOM_NUMBER = 9;

    public List<Integer> GenerateRandomNumber() {
        Set<Integer> computer = new HashSet<>();
        while (computer.size() < 3) {
            computer.add(Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER));
        }
        return new ArrayList<>(computer);
    }
}
