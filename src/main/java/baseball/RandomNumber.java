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
        if (randomNumber.size() >= InputRange.CORRECT_INPUT_RANGE.getValue()) {
            randomNumber.clear();
        }

        while (randomNumber.size() < InputRange.CORRECT_INPUT_RANGE.getValue()) {
            int num = Randoms.pickNumberInRange(InputRange.START_RANDOM_RANGE.getValue(),
                    InputRange.END_RANDOM_RANGE.getValue());
            if (!randomNumber.contains(num)) {
                randomNumber.add(num);
            }
        }
    }
}
