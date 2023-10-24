package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    private static List<Integer> arr;
    private final int min = 1;
    private final int max = 9;

    public RandomNumber() {
        arr = new ArrayList<>();
        createThreeNumber();
    }

    private void createThreeNumber() {
        for (int i = 0; i <= 2; i++) {
            int certifiedNum = validateAlready(Randoms.pickNumberInRange(min, max));
            arr.add(certifiedNum);
        }
    }

    private int validateAlready(int num) {
        if (arr.contains(num)) {
            validateAlready(Randoms.pickNumberInRange(min, max));
        }
        return num;
    }

    public List<Integer> getRandomNumbers() {
        return arr;
    }
}
