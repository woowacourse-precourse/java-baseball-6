package baseball.view;

import baseball.config.GameCommand;
import baseball.util.InputUtil;
import java.util.List;

public class InputView {

    private static final String INPUT_BASEBALL_NUMBER_REQUEST_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_RETRY_OR_QUIT_REQUEST_MESSAGE = "게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.%n";

    public static List<Integer> readBaseBallNumbers() {
        System.out.print(INPUT_BASEBALL_NUMBER_REQUEST_MESSAGE); // TODO: Outputview로 분리하는 것 고민중
        return InputUtil.readIntegerList();
    }

    public static int readGameCommand() {
        // TODO: Outputview로 분리하는 것 고민중
        System.out.printf(INPUT_RETRY_OR_QUIT_REQUEST_MESSAGE, GameCommand.RESTART.getNumber(), GameCommand.QUIT.getNumber());
        return InputUtil.readInt();
    }
}
