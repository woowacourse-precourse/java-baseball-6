package baseball;

import baseball.ui.ConsoleUI;
import baseball.ui.UI;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UI ui = new ConsoleUI();
        BaseballMachine machine = new BaseballMachine(ui);

        machine.start();

    }

}
