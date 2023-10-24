package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Computer {
    private List<Integer> randomNumbers = new ArrayList<>();

    Computer() {
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }
}
