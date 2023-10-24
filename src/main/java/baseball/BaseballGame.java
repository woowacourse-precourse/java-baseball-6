package baseball;

import baseball.domain.AnswerNumbers;
import baseball.domain.PlayerNumbers;
import baseball.domain.RestartCommand;
import baseball.domain.Score;
import baseball.view.InputView;
import baseball.view.OutputView;

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

            guessAnswer();

            inputView.restartGame();
            String command = inputView.readLine();
            if (RestartCommand.isExit(command)) {
                isPlaying = false;
            }
        }
    }

    private void guessAnswer() {

        boolean isContinue = true;
        AnswerNumbers answerNumbers = AnswerNumbers.generate();

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
