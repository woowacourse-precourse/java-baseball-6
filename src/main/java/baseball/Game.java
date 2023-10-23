package baseball;

import baseball.domain.Computer;
import baseball.domain.User;
import java.util.List;

public class Game {
    Computer computer = new Computer();
    User user = new User();

    public void startGame() {
        View.printStartGameMessage();
        List<Integer> answerNumberList = computer.createAnswerNumberList();
    }

    private void compareNumbers(List<Integer> answerNumberList, List<Integer> userNumberList) {
        int ball = 0;
        int strike = 0;

        for (int oneDigit = 0; oneDigit < answerNumberList.size(); oneDigit++) {
            if (answerNumberList.get(oneDigit).equals(userNumberList.get(oneDigit))) {
                strike++;
            } else if (answerNumberList.contains(userNumberList.get(oneDigit))) {
                ball++;
            }
        }
    }
}
