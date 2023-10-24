package baseball.baseballV2.view.inputview;

import baseball.baseballV2.model.TripleBalls;
import baseball.baseballV2.system.converter.InputToTripleBallsConverter;
import baseball.baseballV2.system.validator.InputNumberValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.Map;

public class EnterTripleBallsInputView implements InputView<TripleBalls> {
    @Override
    public TripleBalls input(Map<String, Object> model) {
        String input = readInput();
        new InputNumberValidator(input);
        return InputToTripleBallsConverter.convert(input);
    }

    private String readInput() {
        return Console.readLine();
    }
}
