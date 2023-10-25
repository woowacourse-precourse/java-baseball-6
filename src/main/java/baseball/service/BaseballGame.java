package baseball.service;

import baseball.console.Input;
import baseball.console.Output;
import baseball.entity.Computer;
import baseball.entity.User;

import java.util.HashSet;

import static baseball.constants.Constants.NUMBER_LENGTH;
import static baseball.constants.Constants.REQUIRED_STRIKES_FOR_WIN;
import static baseball.constants.Messages.START_MESSAGE;

public class BaseballGame {

    private static final String RESTART_CHOICE = "1";

    private User user;
    private Computer computer;
    private GameLogic gameLogic;

    public BaseballGame() {
        System.out.println(START_MESSAGE.getMessage());
        user = new User();
        computer = new Computer();
        gameLogic = new GameLogic();
    }

    public void start() {
        do {
            playSingleRound();
        } while (isUserWantsToRestart());
    }

    private void playSingleRound() {
        computer.generateRandomAnswer();
        do {
            user.setNumber(Input.get());
        } while (!gameLogic.isGuessCorrect(user.getNumber(), computer.getAnswer()));
        Output.printAnswerMessage();
    }

    private boolean isUserWantsToRestart() {
        return RESTART_CHOICE.equals(Input.restart());
    }
}

