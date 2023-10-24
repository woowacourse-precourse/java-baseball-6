package baseball.vo;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RandomNumbers {
    private List<Integer> randomNumbers;

    public RandomNumbers() {
        randomNumbers = Randoms.shuffle(setRandomNumbers());
    }

    private List<Integer> setRandomNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while(numbers.size() < 3) {
            numbers.add(Randoms.pickNumberInRange(1, 9));
        }

        return new ArrayList<>(numbers);
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }
}
