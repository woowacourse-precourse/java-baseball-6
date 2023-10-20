package baseball.Controller;

import baseball.Model.Computer;
import baseball.Model.Count;
import baseball.Model.User;
import baseball.View.Input;
import baseball.View.Output;

import java.util.HashMap;
import java.util.Map;

public class BaseballController {
    private final Computer computer;
    private final User user;
    private final Count strike;
    private final Count ball;

    public BaseballController() {
        computer = new Computer();
        user = new User();
        strike = new Count();
        ball = new Count();
    }

    public void start() {
        computer.setNumber();
        do {
            ball.setCount(0);
            strike.setCount(0);
            getUserNumber();
            compare(user.getNumber());
            handleGuessResult();
            Output.print();

            if (strike.getCount() == 3) {
                Output.printEndMessage();
            }
        } while (!computer.getNumber().equals(user.getNumber()));
    }

    public void getUserNumber() {
        String num = Input.setUserNumber();
        user.setNumber(num);
    }

    public void compare(String userNum) {
        String computerNum = computer.getNumber();
        int len = computerNum.length();

        for (int i = 0; i < len; i++) {
            if (computerNum.charAt(i) == userNum.charAt(i)) {
                strike.addCount();
            } else if (computerNum.contains(String.valueOf(userNum.charAt(i)))) {
                ball.addCount();
            }
        }
    }

    public void handleGuessResult() {
        if (strike.getCount() == 0 && ball.getCount() == 0) {
            Output.printNothingMessage();
        } else {
            if (ball.getCount() > 0) {
                Output.printCount(ball.getCount());
                Output.printBallMessage();
            }
            if (strike.getCount() > 0) {
                Output.printCount(strike.getCount());
                Output.printStrikeMessage();
            }
        }
    }

}
