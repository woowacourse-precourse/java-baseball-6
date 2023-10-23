package baseball.Controller;

import baseball.Model.ComputerNumberPicker;
import baseball.View.InputView;
import baseball.View.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameController {
    public void startGame() {
        OutputView.printStart();
        do {
            playOneRoundGame();
        } while (!endGame());
    }

    public void playOneRoundGame() {
//        do {
            int[] computer = new ComputerNumberPicker().computer;

//        } while ();
    }

    private static boolean endGame() throws IllegalArgumentException{
        String userInput = InputView.confirmRestart();
        if (userInput.equals("1")) {
            return false;
        } else if (userInput.equals("2")) {
            return true;
        }
        throw new IllegalArgumentException();
    }



}
