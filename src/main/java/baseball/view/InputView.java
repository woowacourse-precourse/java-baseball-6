package baseball.view;

import baseball.model.GameRestartOrNot;
import baseball.model.StringNumbers;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getConsoleInput() {
        return Console.readLine();
    }

    public static StringNumbers getUserBaseballNumbersString() {
        OutputView.printEnterNumber();
        return new StringNumbers(Console.readLine());
    }

    public static GameRestartOrNot getGameRestartOrNot() {
        OutputView.printAnswer();
        return new GameRestartOrNot(Console.readLine());
    }

    public static String getRestartOrNot() {
        OutputView.printAnswer();
        return Console.readLine();
    }
}
