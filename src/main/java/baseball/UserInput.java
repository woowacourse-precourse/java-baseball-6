package baseball;

import static baseball.InputValidator.gameInputValidator;
import static baseball.InputValidator.restartInputValidator;
import static baseball.Utils.stringToInt;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {
    private List<Integer> userNum;
    private OutputView outputView;

    UserInput() {
        this.userNum = new ArrayList<>();
        this.outputView = new OutputView();
    }

    public List<Integer> getUserNum() {
        return List.copyOf(userNum);
    }

    public void promptUserInput() {
        outputView.promptMessage();
        String string = Console.readLine();
        gameInputValidator(string);
        userNum = stringToInt(string);
    }

    public int promptUserForRestart() {
        outputView.restartMessage();
        String s = Console.readLine();
        restartInputValidator(s);
        List<Integer> userAnswer = new ArrayList<>(stringToInt(s));
        return userAnswer.get(0);
    }

}
