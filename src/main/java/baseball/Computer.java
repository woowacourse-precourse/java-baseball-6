package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private Numbers numbers;

    public void generateRandomNumbers() {
        List<Integer> randomGeneratedNumberList = new ArrayList<>();
        while (randomGeneratedNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomGeneratedNumberList.contains(randomNumber)) {
                randomGeneratedNumberList.add(randomNumber);
            }
        }
        this.numbers = new Numbers(randomGeneratedNumberList);
    }
}
