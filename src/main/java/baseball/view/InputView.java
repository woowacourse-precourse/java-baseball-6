package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import static baseball.view.constants.StaticNotice.*;

public class InputView {
    public static String askUserNumbers() {
        OutputView.printStaticNotice(ASK_PLAYER_NUMBER);
        return Console.readLine();
    }

    public static String askRestartOrExit() {
        OutputView.printStaticNotice(GAME_OVER);
        OutputView.printStaticNotice(ASK_RESTART_OR_EXIT);
        return Console.readLine();
    }
}
