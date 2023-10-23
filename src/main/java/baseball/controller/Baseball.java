package baseball.controller;

import static baseball.view.Message.endMessage;
import static baseball.view.Message.resultMessage;

import baseball.model.Result;
import baseball.util.Computer;
import java.util.List;

public class Baseball {
    User user = new User();
    Computer computer = new Computer();

    public void playGame() {
        List<Integer> computerNumber = computer.getRandomNumber();
        while (true) {
            String userNumber = user.getUserNumber();
            Result result = compareNumber(userNumber, computerNumber);
            resultMessage(result.getBall(), result.getStrike());
            if (result.getStrike() == 3) {
                endMessage();
                break;
            }
        }
    }

    public Result compareNumber(String userNumber, List<Integer> computerNumber) {
        String[] number = userNumber.split("");
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(number[i]);
            if (computerNumber.get(i) == num) {
                strike++;
            } else if (computerNumber.contains(num)) {
                ball++;
            }
        }
        Result result = new Result(ball, strike);
        return result;
    }

    public boolean replayCheck() {
        return user.inputReplay();
    }
}
