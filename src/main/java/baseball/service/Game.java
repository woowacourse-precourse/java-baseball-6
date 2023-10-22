package baseball.service;

import baseball.domain.Balls;
import baseball.domain.Computer;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    private final Computer computer = new Computer();
    private final Balls userBalls = new Balls();

    public void createComputerBalls() {
        computer.createRandomBalls();
    }

    public void inputUserBalls() {
        String balls = Console.readLine();
        userBalls.convertToBalls(balls);
    }
}
