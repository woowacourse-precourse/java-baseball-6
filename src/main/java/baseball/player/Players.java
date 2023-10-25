package baseball.player;

import baseball.result.Result;

public class Players {
    private User user;
    private Computer computer;

    public void createUserNumber() {
        user = new User();
        user.createNumbers();
    }

    public void createComputerNumber() {
        computer = new Computer();
        computer.createNumbers();
    }

    public Result compareNumbers() {
        return user.compareWith(computer);
    }
}
