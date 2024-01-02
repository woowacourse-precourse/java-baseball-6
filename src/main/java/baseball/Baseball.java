package baseball;

import java.util.ArrayList;
import java.util.HashMap;

import static baseball.Input.*;
import static baseball.Output.*;

public class Baseball {
    private final Computer computer = new Computer();
    public void run () {
        printStartMessage();
        boolean isContinue;
        do {
            playGame();
            printSuccessMessage();
            isContinue = inputGameContinue();
        } while (isContinue);
    }

    private void playGame() {
        computer.init();
        HashMap<String, Integer> result;
        do {
            printInputMessage();
            ArrayList<Integer> numbers = inputNumber();
            result = computer.checkNumber(numbers);
            printResult(result);
        } while (result.get("strike") < 3);
    }
}
