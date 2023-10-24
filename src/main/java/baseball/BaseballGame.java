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

            AnswerNumbers answerNumbers = initializeAnswer();

            guessAnswer(answerNumbers);

            inputView.restartGame();
            String command = inputView.readLine();
            if (RestartCommand.isExit(command)) {
                isPlaying = false;
            }
        }
    }

    private void guessAnswer(AnswerNumbers answerNumbers) {
        while (true) {
            Score.initialize();

            doGuess(answerNumbers);

            if (Score.isWin()) {
                outputView.endGame();
                break;
            }
        }
    }

    private void doGuess(AnswerNumbers answerNumbers) {
        inputView.playerNumber();
        String inputPlayerNumbers = inputView.readLine();

        PlayerNumbers playerNumbers = PlayerNumbers.of(inputPlayerNumbers);

        calculateScore(answerNumbers, playerNumbers);

        outputView.writeMessage(Score.getResultMessage());
    }

    private void calculateScore(AnswerNumbers answerNumbers, PlayerNumbers playerNumbers) {
        for (int index = 0; index < AnswerNumbers.SIZE; index++) {
            if (answerNumbers.contains(playerNumbers.getByIndex(index))) {
                if (answerNumbers.getByIndex(index).equals(playerNumbers.getByIndex(index))) {
                    Score.STRIKE.addCount();
                    continue;
                }
                Score.BALL.addCount();
            }
        }
    }

    private AnswerNumbers initializeAnswer() {
        List<Integer> randomNumbers = RandomNumberGenerator.pickNumbersInRangeWithoutDuplication(1, 9);

        return AnswerNumbers.of(randomNumbers);
    }
}
