package baseball.baseballV2.view.inputview;

import baseball.baseballV2.model.RestartChoice;
import baseball.baseballV2.system.converter.StringToRestartChoiceConverter;
import baseball.baseballV2.system.validator.InputRestartNumberValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.Map;

public class GameRestartInputView implements InputView<RestartChoice> {
    @Override
    public RestartChoice input(Map<String, Object> model) {
        String restartNumber = readInput();
        new InputRestartNumberValidator(restartNumber);
        return StringToRestartChoiceConverter.convert(restartNumber);
    }

    protected String readInput() {
        return Console.readLine();
    }
}
