package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String readUserNumber() {
        OutputView.printInputNumberMessage();
        String inputNumber = Console.readLine();

        return inputNumber;
    }
}
