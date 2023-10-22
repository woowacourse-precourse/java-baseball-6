package baseball.view;

import baseball.constant.GameMessage;
import baseball.util.InputValidator;
import baseball.util.StringToIntegerListParser;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    private final InputValidator inputValidator = new InputValidator();

    public List<Integer> getPlayerInput() {
        System.out.println(GameMessage.REQUIRES_INPUT);
        String input = Console.readLine();

        inputValidator.validate(input);

        return StringToIntegerListParser.parse(input);
    }
}