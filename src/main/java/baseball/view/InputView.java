package baseball.view;

import baseball.constant.GameMessage;
import baseball.util.InputValidator;
import baseball.util.StringToIntegerListParser;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    private final InputValidator inputValidator = new InputValidator();

    public List<Integer> getPlayerInput() {
        System.out.print(GameMessage.REQUIRES_INPUT.getMessage());
        String input = Console.readLine();

        inputValidator.validateGameNumber(input);

        return StringToIntegerListParser.parse(input);
    }

    public Integer getRestart() {
        System.out.println(GameMessage.ASK_RESTART.getMessage());
        String input = Console.readLine();

        inputValidator.validateRestartNumber(input);

        return Integer.parseInt(input);
    }
}