package baseball;

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
            String input = readBallInput();
            computer.compareInput(input);
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
