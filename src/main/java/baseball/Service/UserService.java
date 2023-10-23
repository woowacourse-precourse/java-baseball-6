package baseball.Service;

import baseball.model.NumberList;
import baseball.util.Parser;
import baseball.view.TextInterface;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class UserService {
    private final TextInterface textInterface = new TextInterface();
    private final Parser parser = new Parser();
    NumberList userAnswer;

    public List<Integer> readAnswer() {
        textInterface.isWaiting();
        return setAnswer(Console.readLine());
    }

    public List<Integer> setAnswer(String inputString) {
        List<Integer> inputList = parser.stringToIntegerList(inputString);
        userAnswer = new NumberList(inputList);
        return inputList;
    }
}
