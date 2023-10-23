package baseball.view;

import baseball.model.GameRestartString;
import baseball.model.StringNumbers;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static StringNumbers getStringNumbers() {
        OutputView.printEnterNumber();
        String input = Console.readLine();
        return new StringNumbers(input.trim());
    }

    public static GameRestartString getGameRestartString() {
        OutputView.printAnswer();
        String input = Console.readLine();
        return new GameRestartString(input.trim());
    }
}
