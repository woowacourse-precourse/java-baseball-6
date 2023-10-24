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

    private boolean isRunning;

    public BaseballGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.isRunning = true;
    }

    public void execute() {

        outputView.executeGame();

        while (isRunning) {

            playGame();

            inputView.restartGame();
            String command = inputView.readLine();
            if (RestartCommand.isExit(command)) {
                isRunning = false;
            }

            outputView.endGame();
        }
    }

    private void playGame() {

        boolean isContinue = true;
        AnswerNumbers answerNumbers = AnswerNumbers.generate();

        while (isContinue) {
            Score.initialize();
            doPlay(answerNumbers);
            isContinue = !Score.isWin();
        }
    }

    private void doPlay(AnswerNumbers answerNumbers) {

        inputView.playerNumber();

        String inputPlayerNumbers = inputView.readLine();
        PlayerNumbers playerNumbers = PlayerNumbers.of(inputPlayerNumbers);
        answerNumbers.calculateScore(playerNumbers);

        outputView.writeMessage(Score.getResultMessage());
    }
}
