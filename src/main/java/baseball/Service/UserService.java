package baseball.Service;

import static baseball.util.Constants.NUMBER_SIZE;

import baseball.model.User;
import baseball.util.Parser;
import baseball.view.TextInterface;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class UserService {
    private User user;
    private final TextInterface textInterface = new TextInterface();
    private final Parser parser = new Parser();

    public String waitInput() {
        textInterface.isWaiting();
        String input = Console.readLine();
        if (input.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public List<Integer> setInput(String inputString) {
        List<Integer> inputList = parser.stringToIntegerList(inputString);
        user = new User(inputList);
        return inputList;
    }
}
