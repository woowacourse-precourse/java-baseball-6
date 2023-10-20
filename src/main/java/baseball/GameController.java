package baseball;

import java.util.List;

public class GameController {

    public void start() {
        run();


    }

    private void run() {
        OutputView.printStart();
        Balls answerBalls = generateAnswerBalls();
        Balls playerBalls = InputView.scanBalls();
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
