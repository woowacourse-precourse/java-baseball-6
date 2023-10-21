package baseball;

import computer.Comparator;
import computer.Computer;
import user.User;

public class BaseBallGame implements Game{

    private Balls userBalls;
    private Balls computerBalls;
    Computer computer = new Computer();
    GameRule rule = new BaseBallRule();
    @Override
    public void start() {
        computerBalls=computer.makeComputerNumber();

    }

    @Override
    public void over() {

    }

    public void receiveUserBalls(Balls userBalls){
        this.userBalls=userBalls;
    }
}
