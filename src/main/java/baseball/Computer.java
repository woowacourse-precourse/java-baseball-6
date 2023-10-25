package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Computer {
    private static final Computer instance = new Computer();
    private static final int SIZE = 3;
    private static int[] arr = new int[SIZE];
    private Computer() {}
    public static Computer getInstance() {
        return instance;
    }

    public int[] setRandomNums() {
        Set<Integer> numbers = new HashSet<>();
        int idx = 0;

        while (numbers.size() < SIZE) {
            int r = Randoms.pickNumberInRange(1, 9);
            numbers.add(r);
        }

        for (Integer num : numbers) {
            arr[idx] = num;
            idx += 1;
        }
        return arr;
    }

    public void resetNums() {
        arr = setRandomNums();
    }
}
