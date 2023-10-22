package baseball.domain.computer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final String END_POINT = "3스트라이크";

    private final BaseballAlgorithm baseballAlgorithm;
    private boolean eachSetContext;

    public Computer(BaseballAlgorithm baseballAlgorithm) {
        this.baseballAlgorithm = baseballAlgorithm;
        this.eachSetContext = true;
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

    public boolean isEachSetContext() {
        return eachSetContext;
    }

    public void updateEachSetContext(String message) {
        if (message.equals(END_POINT)) {
            eachSetContext = false;
        }
    }

    public void clearEachSetContext() {
        eachSetContext = true;
    }
}
