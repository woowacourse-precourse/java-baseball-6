package baseball.controller;

import baseball.constant.Const;
import baseball.model.Hint;
import baseball.model.Judge;
import baseball.model.Computer;
import baseball.model.User;

import static baseball.model.Computer.createRandomNumbers;
import static baseball.view.Message.*;

public class Game {
    public Game() {
        printStartMessage();
    }

    public void play() {
        Computer computer = createRandomNumbers();
        User user = new User();
        Judge judge = new Judge();
        Hint.init();

        while (Hint.getStrikeCount() != Const.MAX_NUMBER_SIZE) {
            user.inputNumbers();
            judge.createHint(user, computer);
            printHint();
        }

        printGameEnd();

        if (judge.isReset(user)) {
            play();
        }
    }
}
