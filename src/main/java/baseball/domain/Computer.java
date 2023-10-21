package baseball.domain;

import baseball.validator.BaseballValidator;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final Integer RANDOM_NUMBER_START = 1;
    private static final Integer RANDOM_NUMBER_END = 9;
    private static final Integer RANDOM_NUMBER_SIZE = 3;

    private List<Integer> computerBall;
    public Computer (){};
    public void setComputerBall(List<Integer> baseball) {
        if (BaseballValidator.validator(baseball)) {
            this.computerBall = baseball;
        }
    }

    public List<Integer> getComputerBall() {
        return computerBall;
    }

    public void createComputerBall(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < RANDOM_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_END);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        setComputerBall(computer);
    }
}
