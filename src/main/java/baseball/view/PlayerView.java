package baseball.view;

import baseball.constant.GameMessage;
import baseball.validator.InputValidator;
import baseball.util.StringToIntegerListParser;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class PlayerView {

    public List<Integer> getPlayerInput() {
        System.out.print(GameMessage.REQUIRES_INPUT.getMessage());
        String input = Console.readLine();

        InputValidator.validateGameNumber(input);

        return StringToIntegerListParser.parse(input);
    }
}