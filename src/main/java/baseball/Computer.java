package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int NUMBER_LENGTH = 3;
    private static final int MIN = 1;
    private static final int MAX = 9;
    private final List<Integer> computerNumber = new ArrayList<>();

    public Computer() {
        randomNumberGenerate();
    }

    public void randomNumberGenerate() {
        computerNumber.clear();

        while (computerNumber.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN, MAX);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    public List<Integer> getRandomNumber() {
        return computerNumber;
    }
}
