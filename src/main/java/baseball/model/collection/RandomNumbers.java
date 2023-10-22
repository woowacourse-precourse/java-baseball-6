package baseball.model.collection;

import baseball.utils.RandomNumberUtils;
import java.util.List;

public class RandomNumbers {

    private List<Integer> randomNumbers;

    public RandomNumbers() {
        this.randomNumbers = RandomNumberUtils.createRandomNum();
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }
}
