package baseball.view;

import baseball.exception.BaseballGameException;
import camp.nextstep.edu.missionutils.Console;
public class InputView {
    BaseballGameException baseballGameException = new BaseballGameException();
    public int readPlayerNum() {
        String playerNumStr = Console.readLine();
        baseballGameException.validPlayerNumIsInt(playerNumStr);
        baseballGameException.validPlayerNumLenCount(playerNumStr);
        baseballGameException.validPlayerNumIsDuplicate(playerNumStr);
        return Integer.parseInt(playerNumStr);
    }

    public String readRegameOrEnd() {
        String regameNumStr = Console.readLine();
        baseballGameException.validRegameNumStrLen(regameNumStr);
        baseballGameException.validRegameNumStrIsCorrect(regameNumStr);
        return regameNumStr;
    }
}
