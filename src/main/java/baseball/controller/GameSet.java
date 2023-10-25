package baseball.controller;

import baseball.domain.CompareNumber;
import baseball.domain.ComputerNumber;
import baseball.domain.PlayerNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameSet {

    private ComputerNumber computer;
    private CompareNumber compareNumber;
    private boolean reGame = true;
    private boolean success = false;


    public void gameStart() {
        compareNumber = new CompareNumber();
        OutputView.startMessage();
        do {
            computer = new ComputerNumber();
            answerCheck();
        } while (reGame = reStartOrOver());
    }

    public void answerCheck() {
        do {
            PlayerNumber playerNumber = new PlayerNumber(InputView.getPlayerNumber());
            int[] result = compareNumber.getResult(playerNumber.getPlayerNumber(), computer.getComputerNumber());
            success = compareNumber.successCheck(result);
            OutputView.resultCheck(result);
        } while (!success);
    }

    public boolean reStartOrOver() {
        String check = InputView.getReStartOrOverNumber();
        if (check.equals("2")) {
            return false;
        }
        return true;
    }
}
