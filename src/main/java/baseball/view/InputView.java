package baseball.view;

import static baseball.view.OutputView.printStaticNotice;
import static baseball.view.constants.StaticNotice.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static String askPlayerNumbers() {
        printStaticNotice(ASK_PLAYER_NUMBER);
        return readLine();
    }

    public static String askRestartOrExit() {
        printStaticNotice(GAME_OVER);
        printStaticNotice(ASK_RESTART_OR_EXIT);
        return readLine();
    }
}
