package baseball.Service;

import baseball.model.Player;
import baseball.util.Parser;
import baseball.view.TextInterface;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class UserService {
    private final TextInterface textInterface = new TextInterface();
    private final Parser parser = new Parser();
    Player user;

    public List<Integer> inputAnswer() {
        textInterface.isWaiting();
        return setAnswer(Console.readLine());
    }

    public List<Integer> setAnswer(String inputString) {
        List<Integer> inputList = parser.stringToIntegerList(inputString);
        user = new Player(inputList);
        return inputList;
    }
}
