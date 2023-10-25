package baseball.domain;

import baseball.ui.Output;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer implements Player {

    private final Output output;
    private List<Integer> numbers;

    public Computer(Output output) {
        this.output = output;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public void generatePlayerNumber(int NUMBER_BALLS) {
        numbers = generateRandomNumber(NUMBER_BALLS);
    }

    private List<Integer> generateRandomNumber(int NUMBER_BALLS) {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < NUMBER_BALLS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    public void announceResult(BallCounter ballCounter) {
        output.print(ballCounter.toString());
    }

}