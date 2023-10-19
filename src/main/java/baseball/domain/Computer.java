package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> randomNumber;

    public Computer() {
        this.randomNumber = generateRandomNumber();
    }

    private List<Integer> generateRandomNumber() {
        List<Integer> randomData = new ArrayList<>();
        while (randomData.size() < 3) {
            int randomNumberForComputer = Randoms.pickNumberInRange(1, 9);
            if (!randomData.contains(randomNumberForComputer)) {
                randomData.add(randomNumberForComputer);
            }
        }
        return randomData;
    }

    public List<Integer> getRandomNumber() {
        return randomNumber;
    }
}
