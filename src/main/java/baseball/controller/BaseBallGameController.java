package baseball.controller;

import baseball.model.Computer;
import baseball.model.User;
import baseball.view.InputView;

public class BaseBallGameController {
    private final Computer computer;
    private final User user;
    private final MiddleManController middleManController;

    public BaseBallGameController() {
        computer = new Computer();
        user = new User();
        middleManController = new MiddleManController();
    }

    public void play() {
        computer.makeAnswerNumber();
        InputView.gameStartMessage();
        while (true) {
            user.setUserNumber(InputView.inputNumber());
            if (middleManController.isCorrectAnswer(computer.getAnswerNumber(), user.getUserNumber())) {
                break;
            }
        }
        if (user.isRestart(InputView.inpuRestartNumber())) {
            play();
        }
    }
}
