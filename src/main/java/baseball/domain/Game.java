package baseball.domain;

import baseball.feature.GenerateRandomNumber;
import java.util.List;

public class Game {

    public void start() {
        User userObj = new User();
        Computer computerObj = new Computer();
        List<Integer> computer = new GenerateRandomNumber().generateNumber();

        while (true) {
            List<Integer> user = userObj.inputNumber();
            if (computerObj.compareNumber(computer, user)) {
                break;
            }
        }
    }

}
