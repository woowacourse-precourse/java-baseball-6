package baseball.view.impl.gameEnd;

import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;

public class ContinueOrExitInputView implements InputView<String> {
    @Override
    public String getInput() {
        return Console.readLine();
    }
}
