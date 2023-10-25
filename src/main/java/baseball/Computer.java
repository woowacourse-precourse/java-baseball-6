package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    int LENGTH = 3;
    public RandomNums randomNums;

    public void createRandomNums() {
        List<Integer> randomNumList = new ArrayList<>();

        while (randomNumList.size() < LENGTH) {
            addNums(randomNumList, Randoms.pickNumberInRange(1, 9));
        }
        randomNums = new RandomNums(randomNumList);
    }

    private static void addNums(List<Integer> randomNumList, int randomNum) {
        if (!randomNumList.contains(randomNum)) {
            randomNumList.add(randomNum);
        }
    }

    public List<Integer> getRandomNums() {
        return randomNums.getNums();
    }
}
