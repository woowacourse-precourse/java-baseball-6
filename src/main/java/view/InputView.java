package view;

import domain.Numbers;
import camp.nextstep.edu.missionutils.Console;

import static validator.CommandValidator.*;

public class InputView {
    public static Numbers readNumbers() {
        OutputView.printStartGameMessage();
        OutputView.printInputMessage();

        String input = Console.readLine();
        return new Numbers(input);
    }

    public static String readRestartOrEndGame() {
        OutputView.printRestartOrEnd();

        String input = Console.readLine();
        validateRestartNumber(input);
        return input;
    }
}