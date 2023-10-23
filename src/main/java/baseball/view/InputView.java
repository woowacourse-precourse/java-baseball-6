package baseball.view;

import baseball.model.GameRestartOrNot;
import baseball.model.StringNumbers;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static StringNumbers getUserBaseballNumbersString() {
        OutputView.printEnterNumber();
        String input = Console.readLine();
        return new StringNumbers(input.trim());
    }

    public static GameRestartOrNot getGameRestartOrNot() {
        OutputView.printAnswer();
        String input = Console.readLine();
        return new GameRestartOrNot(input.trim());
    }
}
