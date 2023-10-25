package baseball.Controller;

import baseball.Model.BaseballComparator;
import baseball.Model.ComputerNumberPicker;
import baseball.Model.GameConstant;
import baseball.Model.UserNumberPicker;
import baseball.View.InputView;
import baseball.View.OutputView;

public class BaseballGameController {
    public void startGame() {
        OutputView.printStart();
        do {
            playOneRoundGame();
        } while (!endGame());
    }

    public void playOneRoundGame() {
        boolean threeStrike;
        int[] computer = new ComputerNumberPicker().computer;
        do {
            int[] user = new UserNumberPicker().user;
            BaseballComparator round = new BaseballComparator(computer, user);
            OutputView.printGameResult(round.strikeCount, round.ballCount);
            threeStrike = round.checkThreeStrike();
        } while (!threeStrike);
        OutputView.printEnd();
    }

    private static boolean endGame() throws IllegalArgumentException{
        String userInput = InputView.confirmRestart();
        if (userInput.equals(GameConstant.RESTART)) {
            return false;
        } else if (userInput.equals(GameConstant.QUIT)) {
            return true;
        }
        throw new IllegalArgumentException();
    }



}
