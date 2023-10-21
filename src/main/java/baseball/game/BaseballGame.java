package baseball.game;

import baseball.balls.Balls;
import baseball.results.Results;
import baseball.utils.BallsUtils;
import baseball.utils.ResultsUtils;
import baseball.view.ConsoleView;
import baseball.view.View;

public class BaseballGame implements Game {

    private final View view = new ConsoleView();

    private Results results;

    public void run() {

        view.displayGameStartMessage();

        do {

            Balls answerBalls = BallsUtils.generateRandomBalls();

            do {

                view.displayRequestNumberMessage();

                String inputString = view.inputString();
                Balls balls = BallsUtils.convertStringToBalls(inputString);

                results = ResultsUtils.determineResults(balls, answerBalls);

                view.displayResults(results);

            } while (!results.isAnswer());

            view.displayCongratulationMessage();

            view.displayAskRestartMessage();

        } while (goonaRestart());

    }

    private boolean goonaRestart() {
        String inputString = view.inputString();
        return RestartStatus.gonnaRestart(inputString);
    }

}
