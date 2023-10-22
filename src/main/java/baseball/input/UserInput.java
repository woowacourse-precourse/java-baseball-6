package baseball.input;

import baseball.Error.ErrorCheck;
import baseball.output.Message;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    static List<Integer> userInput = new ArrayList<>();
    static String input;
    public static List<Integer> inputNumbers(){
        Message.printInputMessage();
        input = Console.readLine();
        ErrorCheck.checkLength(input);
        userInput = ErrorCheck.checkNumber(input);
        ErrorCheck.checkDuplicate(userInput);

        return userInput;
    }
}
