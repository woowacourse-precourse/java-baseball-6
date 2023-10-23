package baseball.view;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

import static baseball.Application.computerRandomBalls;

public class ComputerRandomBalls {
    public List<Integer> outputRandomBall(){
        while (computerRandomBalls.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerRandomBalls.contains(randomNumber)) {
                computerRandomBalls.add(randomNumber);
            }
        }
        System.out.println("랜덤볼은"+ computerRandomBalls.get(0)+ computerRandomBalls.get(1)+ computerRandomBalls.get(2));
        return computerRandomBalls;
    }
}