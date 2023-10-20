package baseball.domain;

import baseball.validator.BaseballValidator;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final Integer RANDOM_START = 1;
    private static final Integer RANDOM_END = 9;
    private static final Integer RANDOM_SIZE = 3;

    List<Integer> baseball;
    public Computer (){};
    public void setBaseball(List<Integer> baseball) {
        this.baseball = baseball;
    }

    public List<Integer> getBaseball() {
        return baseball;
    }

    public void createComputerBall(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < RANDOM_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_START, RANDOM_END);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        if (BaseballValidator.validator(computer)) {
            this.baseball = computer;
        }
    }
}
