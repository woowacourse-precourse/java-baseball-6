package baseball.view;

import baseball.domain.User;
import baseball.service.InputException;
import java.util.List;

public class InputView {
    public static void makeGameNumber(String userInput) {
        List<Integer> userNumber = InputException.changeStringToNumbers(userInput);
        User.setUser(userNumber);
    }
}
