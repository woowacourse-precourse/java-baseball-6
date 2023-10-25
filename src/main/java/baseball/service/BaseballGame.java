package baseball.service;

import baseball.console.Input;
import baseball.console.Output;
import baseball.constants.RestartChoice;
import baseball.entity.Computer;
import baseball.entity.User;

import static baseball.constants.Messages.START_MESSAGE;

public class BaseballGame {

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
        return RestartChoice.RESTART.matches(Input.restart());
    }
}

