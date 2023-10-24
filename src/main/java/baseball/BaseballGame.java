package baseball;

import java.util.ArrayList;
import java.util.List;

import baseball.controller.Computer;
import baseball.controller.User;
import baseball.model.Numbers;
import baseball.model.Score;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private final static User user = new User();
    public void play() {
        while (true) {
            String isFinish = userTry();

            System.out.println("checking game end! " + isFinish);
            if (isGameEnd(isFinish)) {
                break;
            }

        }
    }

    private boolean isGameEnd(String isFinish) {
        Validator validator = new Validator();
        validator.checkValidGameEnd(isFinish);
        if (isFinish.equals("2")) {
            return true;
        }
        return false;
    }

    private String userTry() {
        Computer computer = new Computer();
        System.out.println("정답: " + computer);
        while (true) {
            List<Integer> userInput = user.userInput();
            Score score = computer.compare(userInput);
            if (!computer.isWin(score)) break;
        }

        return Console.readLine();
    }
}
