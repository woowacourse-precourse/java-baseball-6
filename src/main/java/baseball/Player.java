package baseball;

import constants.Constants;
import game.Ball;
import game.Computer;

public class Player {

    private Computer computer;
    private Ball playerBall;

    public void start() {
        System.out.print(Constants.GAME_START + "\n");
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
            System.out.print(Constants.INPUT_NUMBER);
            playerBall = new Ball(Input.readNumber());
        } while (!computer.catchBall(playerBall));
        System.out.print(Constants.GAME_OVER + "\n");
        System.out.print(Constants.INPUT_OPTION);
    }

    private boolean finish() {
        String option = Input.readOption();
        return !option.equals(Constants.FINISH);
    }

}
