package baseball.game;

import baseball.balls.Balls;
import baseball.results.Results;
import baseball.utils.BallsUtils;
import baseball.utils.ResultsUtils;
import baseball.view.ConsoleView;
import baseball.view.View;

public class BaseballGame implements Game {

    private final View view = new ConsoleView();

    private Balls answerBalls;
    private Balls balls;
    private Results results;

    public void run() {

        view.displayGameStartMessage();

        do {
            generateAnswer();

            do {
                view.displayRequestNumberMessage();
                inputBalls();

                determineResults();
                view.displayResults(results);

            } while (!isAnswer());

            view.displayCongratulationMessage();
            view.displayAskRestartMessage();

        } while (gonnaRestart());

    }

    private void generateAnswer() {
        answerBalls = BallsUtils.generateRandomBalls(1,9,3);
    }

    private void inputBalls() {
        String inputString = view.inputString();
        balls = BallsUtils.convertStringToBalls(inputString);
    }

    private void determineResults() {
        results = ResultsUtils.determineResults(balls, answerBalls);
    }

    private boolean isAnswer() {
        return results.isAnswer();
    }

    private boolean gonnaRestart() {
        String inputString = view.inputString();
        return RestartStatus.gonnaRestart(inputString);
    }

}
