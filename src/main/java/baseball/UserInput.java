package baseball;

import static baseball.Utils.stringToInt;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {
    private List<Integer> userNum;

    UserInput() {
        this.userNum = new ArrayList<>();
    }

    public List<Integer> getUserNum() {
        return List.copyOf(userNum);
    }

    public void promptUserInput() {
        OutputView.promptMessage();
        String string = Console.readLine();
        InputValidator.gameInputValidator(string);
        userNum = stringToInt(string);
    }

    public int promptUserForRestart() {
        OutputView.restartMessage();
        String s = Console.readLine();
        InputValidator.restartInputValidator(s);
        List<Integer> userAnswer = new ArrayList<>(stringToInt(s));
        return userAnswer.get(0);
    }

}
