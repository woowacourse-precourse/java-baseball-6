package baseball.view;

import baseball.util.MessageUtil;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readBaseballNumber(){
        String inputNumber = Console.readLine();
        System.out.println(inputNumber);
        return inputNumber;
    }

    public String readRetryCommand(){
        String inputCommand = Console.readLine();
        System.out.println(inputCommand);
        return inputCommand;
    }
}
