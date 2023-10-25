package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
public class Computer {
    public List<Integer> makeRandomNumbers() {
        List<Integer> randomNums = new ArrayList<>();
        while (randomNums.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!randomNums.contains(num)) {
                randomNums.add(num);
            }
        }
        return randomNums;
    }
}
