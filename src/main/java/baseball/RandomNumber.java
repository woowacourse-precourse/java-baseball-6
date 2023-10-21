package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    private List<Integer> randomNumber;

    public RandomNumber() {
        this.randomNumber = new ArrayList<>();
    }

    public List<Integer> getRandomNumber() {
        return this.randomNumber;
    }

    public void randomNumberGenerate() {
        if (randomNumber.size() >= 3) {
            randomNumber = new ArrayList<>();
        }

        while (randomNumber.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!randomNumber.contains(num)) {
                randomNumber.add(num);
            }
        }
    }
}
