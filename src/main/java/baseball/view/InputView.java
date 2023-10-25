package baseball.view;

import baseball.util.MessageConst;
import baseball.util.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputPlayerNumber() {
        System.out.print(MessageConst.INPUT_MSG);
        String playerNumber = Console.readLine();
        Validator.getValidatedPlayerNumber(playerNumber);
        return playerNumber;
    }

    public int inputRestartOrStop() {
        System.out.println(MessageConst.OPTION_MSG);
        String optionNumber = Console.readLine();
        Validator.getValidatedOptionNumber(optionNumber);
        return Integer.parseInt(optionNumber);
    }
}
