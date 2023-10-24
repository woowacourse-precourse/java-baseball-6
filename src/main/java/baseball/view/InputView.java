package baseball.view;

import baseball.domain.User;
import baseball.service.InputException;
import java.util.List;

public class InputView {
    public static void makeGameNumber(String userInput) {
        List<Integer> userNumber = InputException.changeStringToNumbers(userInput);
        User.setUser(userNumber);
    }

    public static void makeGameRestart(String userInput) {
        int restartNumber = InputException.changeStringToNumber(userInput);
        User.setRestart(restartNumber);
    }
}
