package baseball.controller;

import baseball.model.GameEndOption;
import baseball.model.NumberComparator;
import baseball.model.NumberStatus;
import baseball.model.ProgramNumber;
import baseball.model.UserNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final NumberComparator numberComparator;
    private final ProgramNumber programNumber;
    private UserNumber userNumber;

    public GameController(NumberComparator numberComparator, ProgramNumber programNumber) {
        this.numberComparator = numberComparator;
        this.programNumber = programNumber;
    }

    public void startGame() {
        OutputView.printStart();
        do {
            playSingleGame();
        } while (isResetRequested());
    }

    private void playSingleGame() {
        setupGameNumber();
        do {
            playSingleRound();
        } while (!isAnswer());
    }

    private void playSingleRound() {
        setUserNumber();
        int[] result = calculateResult();
        OutputView.printScoreMessage(result[0], result[1]);
    }

    private void setupGameNumber() {
        programNumber.createProgramNumber();
    }

    private void setUserNumber() {
        userNumber = new UserNumber(InputView.inputUserNumber());
    }

    private boolean isAnswer() {
        boolean isAllStrike = numberComparator.isAllStrike(NumberStatus.NUMBER_SIZE);
        if (isAllStrike) {
            OutputView.printEnd();
        }
        return isAllStrike;
    }

    private int[] calculateResult() {
        return numberComparator.calculateResult(userNumber.getUserNumber(), programNumber.getProgramNumber());
    }

    private boolean isResetRequested() {
        GameEndOption gameEndOption = new GameEndOption(InputView.resetNumber());
        return gameEndOption.isReset();
    }
}
