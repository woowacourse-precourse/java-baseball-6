package console;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class InputView {
    private static final String RETRY_OPTION = "1";
    public String getUserInput(){
        String userInput = Console.readLine();
        InputValidator.validateInput(userInput);
        return userInput;
    }

    public boolean isContinuable(){
        String userInput = Console.readLine();
        return userInput.equals(RETRY_OPTION);
    }
}