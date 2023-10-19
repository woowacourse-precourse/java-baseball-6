package baseball.controller;

import baseball.domain.Ball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class GameController {
    private Set<BallDto> computer = new LinkedHashSet<>();

    public void start(){
        while (computer.size() < 3){
            Ball ball = new Ball(Randoms.pickNumberInRange(1, 9));
            computer.add(new BallDto(ball.getNumber()));
        }
    }

    public Set<BallDto> getComputer() {
        return computer;
    }
}
