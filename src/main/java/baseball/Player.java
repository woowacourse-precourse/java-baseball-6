package baseball;

import constants.MessageConstants;
import game.Ball;
import game.Computer;

public class Player {

    private Computer computer;
    private Ball playerBall;

    public void start() {
        System.out.print(MessageConstants.GAME_START + "\n");
        do {
            reset();
            play();
        } while (finish());
    }

    private void reset() {
        computer = new Computer();
    }

    private void play() {
        do {
            System.out.print(MessageConstants.INPUT_NUMBER);
            playerBall = new Ball(Input.readNumber());
        } while (!computer.catchBall(playerBall));
        System.out.print(MessageConstants.GAME_OVER + "\n");
        System.out.print(MessageConstants.INPUT_OPTION);
    }

    private boolean finish() {
        String option = Input.readOption();
        return !option.equals("2");
    }

}
