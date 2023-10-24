package baseball.Service;

import baseball.model.Player;
import baseball.util.Parser;
import baseball.view.TextInterface;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class UserService {
    private final TextInterface textInterface = new TextInterface();
    private final Parser parser = new Parser();
    private final Player user = new Player();

    public List<Integer> enterAnswer() {
        textInterface.isWaiting();
        return setAnswer(Console.readLine());
    }

    public List<Integer> setAnswer(String userAnswerString) {
        List<Integer> userAnswer = parser.stringToIntegerList(userAnswerString);
        user.createAnswer(userAnswer);
        return userAnswer;
    }
}
