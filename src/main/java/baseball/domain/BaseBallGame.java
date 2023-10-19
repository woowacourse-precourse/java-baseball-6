package baseball.domain;

import static baseball.view.Input.*;

public class BaseBallGame {
    private final Computer computer;
    private final User user;
    private final MiddleMan middleMan;

    public BaseBallGame() {
        computer = new Computer();
        user = new User();
        middleMan = new MiddleMan();
    }

    public void play() {
        computer.makeAnswerNumber();
        System.out.println(computer.getAnswerNumber());
        gameStartMessage();
        while (true) {
            user.setUserNumber(inputNumber());
            if (middleMan.isCorrectAnswer(computer.getAnswerNumber(), user.getUserNumber())) {
                break;
            }
        }
    }
}
