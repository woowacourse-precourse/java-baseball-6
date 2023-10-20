package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int promptForNumbers() {
        return Integer.parseInt(Console.readLine());
    }
}
