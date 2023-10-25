package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class RandomNumber {
    private final Set<Integer> randomNumbers;

    public RandomNumber() {
        randomNumbers = new HashSet<>();
    }

    public List<Integer> createRandomNumbers() {
        randomNumbers.clear();

        while(randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            randomNumbers.add(randomNumber);
        }

        return new ArrayList<>(randomNumbers);
    }
}
