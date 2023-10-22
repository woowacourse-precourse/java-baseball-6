package baseball.view;

import baseball.model.GameRestartOrNot;
import baseball.model.StringNumbers;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static StringNumbers getUserBaseballNumbersString() {
        OutputView.printEnterNumber();
        return new StringNumbers(Console.readLine());
    }

    public static GameRestartOrNot getGameRestartOrNot() {
        OutputView.printAnswer();
        return new GameRestartOrNot(Console.readLine());
    }
}
