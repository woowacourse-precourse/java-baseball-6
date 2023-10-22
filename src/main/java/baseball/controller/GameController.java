package baseball.controller;

import baseball.model.GameEndOption;
import baseball.model.NumberComparator;
import baseball.model.NumberStatus;
import baseball.model.ProgramNumber;
import baseball.model.UserNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final NumberComparator numberComparator = new NumberComparator();
    private ProgramNumber programNumber;
    private UserNumber userNumber;

    public void startGame() {
        OutputView.printStart();
        do {
            playSingleGame();
        } while (isResetRequested());
    }

    private void playSingleGame() {
        setupGameNumber();
        do {
            setUserNumber();
            int[] result = calculateResult();
            OutputView.printScoreMessage(result[0], result[1]);
        } while (!isAnswer());
    }

    private void setupGameNumber() {
        programNumber = new ProgramNumber();
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
