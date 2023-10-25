package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getUserNumber() {
        String userNumber = Console.readLine();
        return userNumber;
    }

    public String getRetryNumber() {
        String typeNumber= Console.readLine();
        return typeNumber;
    }
}
