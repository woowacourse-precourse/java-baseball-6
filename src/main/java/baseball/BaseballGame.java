package baseball;

import baseball.domain.Computer;
import baseball.domain.Count;
import baseball.domain.Restart;
import baseball.domain.User;

public class BaseballGame {
    private final User user;

    private Computer computer;

    private final Count count;

    private final Restart restart;

    public BaseballGame() {
        user = new User();
        computer = new Computer();
        count = new Count();
        restart = new Restart();
    }

    public void inputUserNumber() {
        user.inputUserNumber();
    }

    public void countAndShow() {
        count.compare(computer.getRandomNumbers(), user.getUserNumbers());
        count.showStatus();
    }

    public boolean checkAndRestart() {
        if (count.checkStrike()) {
            if (restart.doRestart()) {
                computer = new Computer();
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
}
