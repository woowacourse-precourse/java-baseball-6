package baseball.controller;

import baseball.model.Result;
import baseball.util.Computer;
import baseball.view.Message;
import java.util.List;

public class Baseball {
    User user = new User();
    Computer computer = new Computer();

    public void playGame() {
        List<Integer> computerNumber = computer.getRandomNumber();
        while (true) {
            String userNumber = user.getUserNumber();
            Result result = compareNumber(userNumber, computerNumber);
            Message.resultMessage(result.getBall(), result.getStrike());
            if (result.getStrike() == 3) {
                Message.endMessage();
                break;
            }
        }
    }

    public Result compareNumber(String userNumber, List<Integer> computerNumber) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            int number = userNumber.charAt(i) - '0';
            if (computerNumber.get(i) == number) {
                strike++;
            } else if (computerNumber.contains(number)) {
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
