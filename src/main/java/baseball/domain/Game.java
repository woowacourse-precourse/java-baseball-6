package baseball.domain;

import baseball.feature.GenerateRandomNumber;
import java.util.List;

public class Game {

    public void start() {
        User userObj = new User();
        Computer computerObj = new Computer();
        List<Integer> computer = new GenerateRandomNumber().generateNumber();
        compareStart(userObj, computerObj, computer);
    }

    public void compareStart(User userObj, Computer computerObj, List<Integer> computer) {
        while (true) {
            List<Integer> user = userObj.inputNumber();
            if (computerObj.compareNumber(computer, user)) {
                break;
            }
        }
    }

}
