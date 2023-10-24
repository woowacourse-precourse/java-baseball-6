package baseball.baseballV2.view.inputview;

import camp.nextstep.edu.missionutils.Console;
import java.io.IOException;
import java.util.Map;

public class GameRestartInputView implements InputView<String> {
    @Override
    public String input(Map<String, Object> model) {
        try {
            String inputLine = readInput();
            return inputLine;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    protected String readInput() throws IOException {
        return Console.readLine();
    }
}
