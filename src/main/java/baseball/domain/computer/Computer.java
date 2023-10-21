package baseball.domain.computer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final BaseballAlgorithm baseballAlgorithm;

    public Computer(BaseballAlgorithm baseballAlgorithm) {
        this.baseballAlgorithm = baseballAlgorithm;
    }

    public List<Integer> generateRandomNumber() {
        List<Integer> randomNumber = new ArrayList<>();
        while (randomNumber.size() < 3) {
            int pickedNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumber.contains(pickedNumber)) {
                randomNumber.add(pickedNumber);
            }
        }
        return randomNumber;
    }

    public String checkBallAndStrike(List<Integer> randomNumber, String userInput) {
        return baseballAlgorithm.calculateBaseballResult(randomNumber, userInput);
    }
}
