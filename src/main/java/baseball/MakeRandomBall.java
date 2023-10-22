package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

import static baseball.Application.randomBalls;

public class MakeRandomBall {
    public List<Integer> outputRandomBall(){
        while (randomBalls.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomBalls.contains(randomNumber)) {
                randomBalls.add(randomNumber);
            }
        }
        System.out.println("랜덤볼은"+randomBalls.get(0)+randomBalls.get(1)+randomBalls.get(2));
        return randomBalls;
    }
}