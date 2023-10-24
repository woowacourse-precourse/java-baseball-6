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

            AnswerNumbers answerNumbers = AnswerNumbers.generate();

            guessAnswer(answerNumbers);

            inputView.restartGame();
            String command = inputView.readLine();
            if (RestartCommand.isExit(command)) {
                isPlaying = false;
            }
        }
    }

    private void guessAnswer(AnswerNumbers answerNumbers) {

        boolean isContinue = true;

        while (isContinue) {
            Score.initialize();
            doGuess(answerNumbers);
            isContinue = !Score.isWin();
        }

        outputView.endGame();
    }

    private void doGuess(AnswerNumbers answerNumbers) {
        inputView.playerNumber();
        String inputPlayerNumbers = inputView.readLine();

        PlayerNumbers playerNumbers = PlayerNumbers.of(inputPlayerNumbers);

        answerNumbers.calculateScore(playerNumbers);

        outputView.writeMessage(Score.getResultMessage());
    }
}
