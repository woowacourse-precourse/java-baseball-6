package baseball.client;

import baseball.constants.MessageConstants;
import baseball.game.Ball;
import baseball.game.Computer;
import baseball.game.Option;
import baseball.view.Input;
import baseball.view.Output;

public class Player {

    private Computer computer;

    public Player() {
    }

    public void start() {
        Output.printMessage(MessageConstants.GAME_START_MESSAGE);
        do {
            play();
            Output.printMessage(MessageConstants.GAME_FINISH_MESSAGE);
        } while (playAgain());
    }

    private void reset() {
        computer = new Computer();
    }

    private void play() {
        reset();
        while (!computer.isFinish()) {
            pitchBall();
        }
    }

    private void pitchBall() {
        Ball ball = readBallInput();
        computer.catchBall(ball);
    }

    private boolean playAgain() {
        Option option = readOptionInput();
        return !option.isFinish();
    }

    private Ball readBallInput() {
        return new Ball(Input.readNumbers());
    }

    private Option readOptionInput() {
        return Option.findByStatus(Input.readOption());
    }
}
