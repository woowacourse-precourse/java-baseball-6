package baseball.view;

import baseball.exception.BaseballGameException;
import camp.nextstep.edu.missionutils.Console;
public class InputView {
    public int readPlayerNum() {
        BaseballGameException baseballGameException = new BaseballGameException();
        String playerNumStr = Console.readLine();
        baseballGameException.validPlayerNumIsInt(playerNumStr);
        baseballGameException.validPlayerNumLenCount(playerNumStr);
        baseballGameException.validPlayerNumIsDuplicate(playerNumStr);
        return Integer.parseInt(playerNumStr);
    }
}
