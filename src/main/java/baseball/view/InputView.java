package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static baseball.validation.NumbersValidator.validation;

public class InputView {

    public String getUserNumber() {
        String userInput = readLine().trim();
        validation(userInput);
        return userInput;
    }

    public boolean getUserRestart() {
        String restart = readLine().trim();
        if (!(restart.equals("1") || restart.equals("2"))) {
            throw new IllegalArgumentException();
        }
        return restart.equals("1");
    }
}
