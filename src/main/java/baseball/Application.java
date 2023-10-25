package baseball;

import baseball.baseballmachine.BaseballMachine;
import baseball.computer.Computer;
import baseball.player.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballMachine baseballMachine = new BaseballMachine(new Computer(), new Player());
        baseballMachine.run();
    }
}