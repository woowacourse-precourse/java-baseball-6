package baseball;

import java.util.List;

public class GameController {

    public void run() {
        Balls answerBalls = generateAnswerBalls();
    }

    private Balls generateAnswerBalls() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        BallsGenerator randomBallsGenerator = new RandomBallsGenerator();
        List<Ball> answerBalls = randomBallsGenerator.generate(numberGenerator);
        return new Balls(answerBalls);
    }
}
