package baseball.service;

import static baseball.util.MessageFormatter.GAME_START;
import static baseball.util.MessageFormatter.INPUT_OPTION;
import static baseball.util.MessageFormatter.INVALID_INPUT;
import static baseball.util.MessageFormatter.OPTION_EXIT;
import static baseball.util.MessageFormatter.OPTION_RETRY;

import baseball.domain.Computer;
import camp.nextstep.edu.missionutils.Console;

public class GameManager {
    private final Computer computer;
    private final BaseballService bs;

    public GameManager(Computer computer, BaseballService bs) {
        this.computer = computer;
        this.bs = bs;
    }

    public void startGame() {
        System.out.println(GAME_START);
        bs.startGame(computer);
    }

    public boolean isContinue() {
        System.out.println(INPUT_OPTION);
        String userAnswer;
        while (true) {
            userAnswer = Console.readLine();
            if (userAnswer.equals(OPTION_EXIT) || userAnswer.equals(OPTION_RETRY)) {
                return userAnswer.equals(OPTION_EXIT);
            }
            System.out.println(INVALID_INPUT);
        }
    }
}
