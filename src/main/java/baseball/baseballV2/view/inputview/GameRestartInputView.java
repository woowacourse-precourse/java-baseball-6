package baseball.baseballV2.view.inputview;

import baseball.baseballV2.system.validator.InputRestartNumberValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.Map;

public class GameRestartInputView implements InputView<String> {
    @Override
    public String input(Map<String, Object> model) {
        String restartNumber = readInput();
        new InputRestartNumberValidator(restartNumber);
        return restartNumber;
    }

    protected String readInput() {
        return Console.readLine();
    }
}
