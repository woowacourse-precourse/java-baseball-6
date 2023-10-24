package baseball.Input;

import static baseball.Message.InputAnswerMsg.DUPLICATE;
import static baseball.Message.InputAnswerMsg.IS_INTEGER;
import static baseball.Message.InputAnswerMsg.RANGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputAnswerImpl implements InputAnswer {

    private static InputAnswerImpl singleton;

    private InputAnswerImpl() {
    }

    public static InputAnswerImpl getInstance() {
        if (singleton == null) {
            singleton = new InputAnswerImpl();
        }
        return singleton;
    }

    @Override
    public List<Integer> inputAnswer() throws IllegalArgumentException {
        String input = Console.readLine();
        integrateValidation(input);
        return List.of(Integer.parseInt(String.valueOf(input.charAt(0))),
                Integer.parseInt(String.valueOf(input.charAt(1))),
                Integer.parseInt(String.valueOf(input.charAt(2))));
    }

    @Override
    public void integrateValidation(String input) {
        isInteger(input);
        rangeValidation(input);
        duplicateValidation(input);
    }

    @Override
    public void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_INTEGER.getMsg() + input);
        }
    }

    @Override
    public void duplicateValidation(String input) {
        if (input.charAt(0) == input.charAt(1) ||
                input.charAt(0) == input.charAt(2) ||
                input.charAt(1) == input.charAt(2)) {
            throw new IllegalArgumentException(DUPLICATE.getMsg() + input);
        }
    }

    @Override
    public void rangeValidation(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(RANGE.getMsg() + input);
        }
    }
}
