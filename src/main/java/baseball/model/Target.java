package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Target {
    private final List<Integer> numbers = new ArrayList<>();
    private final int[] targetNum = new int[3];

    public Target() {
        for (int i = 1; i < 10; i++) {
            numbers.add(i);
        }
        makeTargetNum();
    }

    public void makeTargetNum() {
        for (int i = 0; i < 3; i++) {
            targetNum[i] = getRandomNum();
            numbers.remove(Integer.valueOf(targetNum[i]));
        }
    }

    public int getRandomNum() {
        return Randoms.pickNumberInList(numbers);
    }

    public int[] getTargetNum() {
        return targetNum;
    }
}
