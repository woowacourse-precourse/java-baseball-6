package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

import static baseball.Application.computer;

public class MakeRandomBall {
    public List<Integer> outputRandomBall(){
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}