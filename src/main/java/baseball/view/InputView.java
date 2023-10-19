package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputNumber() {
        String number = Console.readLine();
        return number;
    }

    public int inputRestartGame() {
        String restart = Console.readLine();
        return Integer.parseInt(restart);
    }
}
