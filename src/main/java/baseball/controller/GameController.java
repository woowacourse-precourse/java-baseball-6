package baseball.controller;

import baseball.model.CompareNumber;
import baseball.model.ProgramNumber;
import baseball.model.ResetGameNumber;
import baseball.model.UserNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final CompareNumber numberComparator = new CompareNumber();
    private ProgramNumber programNumber;
    private UserNumber userNumber;

    private static final String RESET_COMMAND = "1";

    public void run() {
        OutputView.printStart();
        do {
            playGame();
        } while (isResetRequested());
    }

    private void playGame() {
        programNumber = new ProgramNumber();
        do {
            userNumber = new UserNumber(InputView.inputUserNumber());
            int[] result = getResultList();
            OutputView.printScoreMessage(result[0], result[1]);
        } while (!isGameEnd());
    }

    private boolean isGameEnd() {
        if (numberComparator.isThreeStrike()) {
            OutputView.printEnd();
            return true;
        }
        return false;
    }

    private int[] getResultList() {
        return numberComparator.getStrikeBall(userNumber.getUserNumber(), programNumber.getProgramNumber());
    }

    private boolean isResetRequested() {
        ResetGameNumber resetGameNumber = new ResetGameNumber(InputView.resetNumber());
        return resetGameNumber.getResetNumber().equals(RESET_COMMAND);
    }
}
