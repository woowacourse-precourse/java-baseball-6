package baseball.input;

import baseball.error.CheckInputNumbers;
import baseball.output.Message;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    static List<Integer> userInput = new ArrayList<>();
    static String input;

    public static List<Integer> inputNumbers() {
        Message.printInputMessage();
        input = Console.readLine();
        CheckInputNumbers.checkLength(input);
        userInput = CheckInputNumbers.checkNumber(input);
        CheckInputNumbers.checkDuplicate(userInput);

        return userInput;
    }
}
