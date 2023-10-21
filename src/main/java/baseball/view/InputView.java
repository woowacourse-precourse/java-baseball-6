package baseball.view;

import baseball.error.ErrorException;
import baseball.error.GameInputErrorException;
import baseball.error.RetryInpurErrorException;
import baseball.util.MessageUtil;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static ErrorException gameInputErrorException = new GameInputErrorException();
    private final static ErrorException retryInputErrorException = new RetryInpurErrorException();

    public String readBaseballNumber(){
        String inputNumber = Console.readLine();
        gameInputErrorException.checkUserInputValidate(inputNumber);
        return inputNumber;
    }

    public String readRetryCommand(){
        String inputCommand = Console.readLine();
        retryInputErrorException.checkUserInputValidate(inputCommand);
        return inputCommand;
    }
}
