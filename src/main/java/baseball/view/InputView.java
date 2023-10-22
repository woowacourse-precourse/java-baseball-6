package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import static baseball.view.constants.PrintMessage.*;

public class InputView {
    public static String askUserNumbers() {
        OutputView.printInformation(ASK_PLAYER_NUMBER);
        return Console.readLine();
    }

    public static String askRestartOrExit() {
        OutputView.printInformation(GAME_OVER);
        OutputView.printInformation(ASK_RESTART_OR_EXIT);
        return Console.readLine();
    }
}
