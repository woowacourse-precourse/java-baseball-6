package baseball.view;

import baseball.utils.Validation;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final Validation validation = new Validation();

    public String getUserNumber() {
        String userNumber = Console.readLine();
        return userNumber;
    }

    public String getTypeNumber() {
        String typeNumber= Console.readLine();
        return typeNumber;
    }
}
