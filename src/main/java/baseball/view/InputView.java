package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int promptForThreeNumbers() {
        return Integer.parseInt(Console.readLine());
    }

    public static int promptForOneNumbers() {
        return Integer.parseInt(Console.readLine());
    }
}
