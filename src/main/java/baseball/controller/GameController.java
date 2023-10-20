package baseball.controller;

import baseball.domain.Ball;
import baseball.exception.BallException;
import baseball.view.GameOutput;
import baseball.view.UserInput;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class GameController {
    private Set<BallDto> computer;
    private Set<BallDto> user;
    private final GameOutput output = new GameOutput();
    private final UserInput input = new UserInput();
    private final BallException ballException = new BallException();

    public void start(){
        createComputerBall();
        output.printGameStart();
        gameProcess();
    }

    public void gameProcess() {
        String number = input.inputUserNumber();
        ballException.validation(number);
        createUserBall(number);
    }

    public void createComputerBall() {
        computer = new LinkedHashSet<>();
        while (computer.size() < 3){
            Ball ball = new Ball(Randoms.pickNumberInRange(1, 9));
            computer.add(new BallDto(ball.getNumber()));
        }
    }

    public void createUserBall(String number){
        Set<BallDto> userBall = new LinkedHashSet<>();
        char[] charArray = number.toCharArray();
        for (char num : charArray) {
            Ball ball = new Ball(num - '0');
            userBall.add(new BallDto(ball.getNumber()));
        }
        this.user = userBall;
    }

    public Set<BallDto> getComputer() {
        return computer;
    }

    public Set<BallDto> getUser() {
        return user;
    }
}
