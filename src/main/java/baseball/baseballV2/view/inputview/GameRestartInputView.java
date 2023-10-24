package baseball.baseballV2.view.inputview;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;

public class GameRestartInputView implements InputView<String> {
    @Override
    public String input(Map<String, Object> model) {
        String inputLine = readInput();
        return inputLine;
    }

    protected String readInput() {
        return Console.readLine();
    }
}
