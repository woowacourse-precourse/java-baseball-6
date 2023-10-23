package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class Computer {

    private static final int START_NUM = 1;
    private static final int END_NUM = 9;
    private Map<Integer, Integer> numbers;

    private Computer() {
        numbers = new HashMap<>();
    }

    public static Computer init() {
        return new Computer();
    }

    private void generateRandomNumbers() {
        int count = 1;
        while (count <= 3) {
            int randomNumber = Randoms.pickNumberInRange(START_NUM, END_NUM);
            if (numbers.containsKey(randomNumber)) {
                continue;
            }
            numbers.put(randomNumber, count);
            count++;
        }
    }
}
