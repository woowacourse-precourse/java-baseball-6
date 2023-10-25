package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int getUserNumbers() {
        String userString = Console.readLine();
        Validator.invalidUserInputExceptions(userString);

        return Integer.parseInt(userString);
    }

    public static int getRestart() {
        OutputView.printGetRestartMsg();

        String userString = Console.readLine();
        Validator.invalidRestartInputExceptions(userString);

        return Integer.parseInt(userString);
    }
}
