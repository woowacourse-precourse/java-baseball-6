package baseball.controller;

import baseball.domain.balls.Balls;
import baseball.domain.restart.RestartStatus;
import baseball.domain.results.Results;
import baseball.dto.BallsDifferenceDto;
import baseball.utility.RandomBallsGenerator;
import baseball.utility.ConvertorUtils;
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
            playGame();
        } while (gonnaRestart());
    }

    private void playGame() {
        generateAnswer();

        do {
            tryAnswer();
        } while (!isAnswer());

        view.displayCongratulationMessage();
        view.displayAskRestartMessage();
    }

    private void generateAnswer() {
        answerBalls = RandomBallsGenerator.generate();
    }

    private void tryAnswer() {
        view.displayRequestNumberMessage();
        inputBalls();

        determineResults();
        view.displayResults(results);
    }

    private void inputBalls() {
        String inputString = view.inputString();
        balls = ConvertorUtils.convertStringToBalls(inputString);
    }

    private void determineResults() {
        BallsDifferenceDto ballsDifferenceDto = balls.getDifference(answerBalls);
        results = new Results(ballsDifferenceDto);
    }

    private boolean isAnswer() {
        return results.isAnswer();
    }

    private boolean gonnaRestart() {
        String inputString = view.inputString();
        return RestartStatus.gonnaRestart(inputString);
    }

}
