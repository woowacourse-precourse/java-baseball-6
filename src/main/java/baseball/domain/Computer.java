package baseball.domain;

import baseball.ui.Output;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer implements Player {

    private final Output output;
    private List<Ball> numbers;

    public Computer(Output output) {
        this.output = output;
    }

    public List<Ball> getNumbers() {
        return numbers;
    }

    @Override
    public void generatePlayerNumber(int NUMBER_BALLS) {
        numbers = generateRandomNumber(NUMBER_BALLS);
    }

    private List<Ball> generateRandomNumber(int NUMBER_BALLS) {
        List<Ball> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < NUMBER_BALLS) {
            Ball randomBall = new Ball(Randoms.pickNumberInRange(1, 9));
            if (!randomNumbers.contains(randomBall)) {
                randomNumbers.add(randomBall);
            }
        }
        return randomNumbers;
    }

    public void announceResult(BallCounter ballCounter) {
        output.print(ballCounter.toString());
    }
}