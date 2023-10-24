package baseball;

import baseball.domain.*;
import baseball.util.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballGame {

    private final InputView inputView;
    private final OutputView outputView;

    private boolean isPlaying;

    public BaseballGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.isPlaying = true;
    }

    public void run() {

        outputView.startGame();
        play();
    }

    private void play() {

        while (isPlaying) {

            Answer answer = initializeAnswer();

            guessAnswer(answer);

            inputView.restartGame();
            String command = inputView.readLine();
            if (RestartCommand.isExit(command)) {
                isPlaying = false;
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
        for (int index = 0; index < Answer.SIZE; index++) {
            if (answer.contains(playerNumbers.getByIndex(index))) {
                if (answer.getByIndex(index).equals(playerNumbers.getByIndex(index))) {
                    Score.STRIKE.addCount();
                    continue;
                }
                Score.BALL.addCount();
            }
        }
    }

    private Answer initializeAnswer() {
        List<Integer> randomNumbers = RandomNumberGenerator.pickNumbersInRangeWithoutDuplication(1, 9);

        return Answer.of(randomNumbers);
    }
}
