package baseball.Controller;

import baseball.InputView;
import baseball.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameController {
    public void startGame() {
        OutputView.printStart();
        do {
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
        } while (!endGame());
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
