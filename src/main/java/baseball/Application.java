package baseball;

import baseball.machine.BaseballMachine;
import baseball.machine.NormalBaseballMachine;
import baseball.machine.ui.ConsoleUI;
import baseball.machine.ui.UI;

public class Application {
    public static void main(String[] args) {
        UI ui = new ConsoleUI();
        BaseballMachine machine = new NormalBaseballMachine(ui);

        machine.start();

    }

}
