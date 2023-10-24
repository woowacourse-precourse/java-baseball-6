package baseball;

import baseball.domain.*;
import baseball.util.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballGame {

    private static BaseballGame baseballGame = null;
    private final InputView inputView;
    private final OutputView outputView;

    private BaseballGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public static BaseballGame getInstance() {
        if (baseballGame == null) {
            baseballGame = new BaseballGame();
        }
        return baseballGame;
    }

    public void run() {

        outputView.startGame();
        play();
    }

    private void play() {

        while (true) {

            Answer answer = initializeAnswer();

            guessAnswer(answer);

            inputView.restartGame();
            String command = inputView.readLine();
            if (RestartCommand.isExit(command)) {
                break;
            }
        }
    }

    private void guessAnswer(Answer answer) {
        while (true) {
            Score.initialize();

            doGuess(answer);

            if (Score.isWin()) {
                outputView.endGame();
                break;
            }
        }
    }

    private void doGuess(Answer answer) {
        inputView.playerNumber();
        String inputPlayerNumbers = inputView.readLine();

        PlayerNumbers playerNumbers = PlayerNumbers.of(inputPlayerNumbers);

        calculateScore(answer, playerNumbers);

        outputView.writeMessage(Score.getResultMessage());
    }

    private void calculateScore(Answer answer, PlayerNumbers playerNumbers) {
        
    }

    private Answer initializeAnswer() {
        List<Integer> randomNumbers = RandomNumberGenerator.pickNumbersInRangeWithoutDuplication(1, 9);

        return Answer.of(randomNumbers);
    }
}
