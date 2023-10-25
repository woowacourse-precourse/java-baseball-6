package baseball.domain;

import baseball.domain.ball.Ball;
import baseball.domain.ball.Balls;
import baseball.ui.Output;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer implements Player {

    private final Output output;
    private Balls numbers;

    public Computer(Output output) {
        this.output = output;
    }

    public Balls getNumbers() {
        return numbers;
    }

    @Override
    public void generatePlayerNumber(int NUMBER_BALLS) {
        numbers = generateRandomNumber(NUMBER_BALLS);
    }

    private Balls generateRandomNumber(int NUMBER_BALLS) {
        List<Ball> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < NUMBER_BALLS) {
            Ball randomBall = new Ball(Randoms.pickNumberInRange(1, 9));
            if (!randomNumbers.contains(randomBall)) {
                randomNumbers.add(randomBall);
            }
        }
        return new Balls(randomNumbers);
    }

    public void announceResult(BallCounter ballCounter) {
        output.print(ballCounter.toString());
    }
}