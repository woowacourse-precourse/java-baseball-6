package baseball.view;

import baseball.domain.GameNumber;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final int GAME_NUMBER_SIZE = 3;
    private static final int RESTART_OR_EXIT_NUMBER_SIZE = 1;

    public GameNumber playerNumberInput() {
        String inputNum = Console.readLine();
        return new GameNumber(inputNum, GAME_NUMBER_SIZE);
    }

    public GameNumber restartOrExitInput() {
        String inputNum = Console.readLine();
        return new GameNumber(inputNum, RESTART_OR_EXIT_NUMBER_SIZE);
    }

}
