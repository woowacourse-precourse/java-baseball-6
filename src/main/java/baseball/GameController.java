package baseball;

import java.util.List;

public class GameController {

    public void start() {
        OutputView.printStart();
        run();
    }

    private void run() {
        Retry retry = Retry.DEFAULT;
        while (retry != Retry.END) {
            Balls answerBalls = generateAnswerBalls();
            play(answerBalls);
            retry = InputView.scanRetry();
        }
    }

    private void play(Balls answerBalls) {
        boolean gameWin = false;
        while (!gameWin) {
            Balls playerBalls = InputView.scanBalls();
            List<TryResult> tryResults = playerBalls.getTryResultList(answerBalls);
            OutputView.printResult(tryResults);
            gameWin = checkGameWin(tryResults);
        }
        OutputView.printGameOver();
    }

    private boolean checkGameWin(List<TryResult> tryResults) {
        return tryResults.stream()
            .allMatch(tryResult -> tryResult == TryResult.STRIKE);
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
