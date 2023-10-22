package baseball;

import java.util.List;

public class Game {
    User user = new User();
    List<Integer> userNumber;
    Computer computer = new Computer();
    List<Integer> answerNumber;
    Judge judge = new Judge();

    public void play() {
        answerNumber = computer.createAnswerNumber();
        do {
            userNumber = user.userNumber();
        } while (!judge.count(answerNumber, userNumber));
    }
}
