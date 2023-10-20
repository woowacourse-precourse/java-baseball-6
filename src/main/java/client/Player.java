package client;

import baseball.Input;
import constants.StringConstants;
import game.Computer;

public class Player {

    private Computer computer;

    public Player() {
    }

    public void start() {
        play();
        playAgain();
    }

    private void reset() {
        computer = new Computer();
    }

    private void play() {
        reset();
        while (!computer.isFinish()) {
            Ball ball = new Ball(readBallInput());
            computer.judge(ball);
        }
    }

    private void playAgain() {
        String option = readOptionInput();
        if (option.equals(StringConstants.CONTINUE)) {
            start();
        }
    }

    private String readBallInput() {
        return Input.readNumbers();
    }

    private String readOptionInput() {
        return Input.readOption();
    }
}
