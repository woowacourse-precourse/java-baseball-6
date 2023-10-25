package baseball.view;

import baseball.domain.GameNumber;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public GameNumber playerNumberInput() {
        String inputNum = Console.readLine();
        return new GameNumber(inputNum, 3);
    }

    public GameNumber endOrRestartInput() {
        String inputNum = Console.readLine();
        return new GameNumber(inputNum, 1);
    }

}
