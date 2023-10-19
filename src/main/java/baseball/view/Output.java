package baseball.view;

import static constant.Constant.*;

public class Output {
    public void printGameStart() {
        System.out.print(INPUT_MENTION);
    }

    public void printResult(String message) {
        System.out.println(message);
    }

    public void printFin() {
        System.out.println(FINISH);
        System.out.println(RESTART_OR_EXIT);
    }
}
