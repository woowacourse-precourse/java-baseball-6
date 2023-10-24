package baseball.player;

import baseball.util.Result;

public class Players {
    private User user;
    private Computer computer;

    public Players() {
        this.user = new User();
        this.computer = new Computer();
    }

    public void createUserNumber() {
        user.createNumbers();
    }

    public void createComputerNumber() {
        computer.createNumbers();
    }

    public Result compareNumber() {
        return null;
    }
}
