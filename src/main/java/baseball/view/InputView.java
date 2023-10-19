package baseball.view;

import baseball.util.MessageUtil;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readBaseballNumber(){
        MessageUtil.INPUT_BASEBALL_NUMBER_MESSAGE.messagePrintln();
        String inputNumber = Console.readLine();
        System.out.println(inputNumber);
        return inputNumber;
    }

    public String readRetryCommand(){
        MessageUtil.GAME_RETRY_MESSAGE.messagePrintln();
        String inputCommand = Console.readLine();
        System.out.println(inputCommand);
        return inputCommand;
    }
}
