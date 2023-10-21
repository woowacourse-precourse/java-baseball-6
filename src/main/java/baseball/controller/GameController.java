package baseball.controller;

import baseball.model.CompareNumber;
import baseball.model.ProgramNumber;
import baseball.model.ResetGameNumber;
import baseball.model.UserNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    CompareNumber compareNumber = new CompareNumber();
    private ProgramNumber program;
    private UserNumber user;

    public void run() {
        OutputView.printStart();
        do {
            start();
        } while (isReset());
    }

    public void start() {
        program = new ProgramNumber();
        do {
            user = new UserNumber(InputView.inputUserNumber());
            int[] result = getResultList();
            OutputView.printScoreMessage(result[0], result[1]);
        } while (!isEnd());
    }

    public boolean isEnd() {
        if (compareNumber.isThreeStrike()) {
            OutputView.printEnd();
            return true;
        }
        return false;
    }

    public int[] getResultList() {
        return compareNumber.getStrikeBall(user.getUserNumber(), program.getProgramNumber());
    }

    public boolean isReset() {
        ResetGameNumber resetGameNumber = new ResetGameNumber(InputView.resetNumber());
        return resetGameNumber.getResetNumber().equals("1");
    }
}
