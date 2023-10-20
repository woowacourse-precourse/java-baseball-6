package baseball;

import java.util.List;

public class GameController {

    public void run() {
        Balls answerBalls = generateAnswerBalls();
        Balls playerBalls = new Balls(new Ball(1,1), new Ball(2,2), new Ball(3,3));
        int strikeCount = playerBalls.getStrikeCount(answerBalls);
        int ballCount = playerBalls.getBallCount(answerBalls);
    }

    private Balls generateAnswerBalls() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        BallsGenerator randomBallsGenerator = new RandomBallsGenerator();
        List<Ball> answerBalls = randomBallsGenerator.generate(numberGenerator);
        return new Balls(answerBalls);
    }

    Balls generateAnswerBallsTest() {
        return generateAnswerBalls();
    }

}
