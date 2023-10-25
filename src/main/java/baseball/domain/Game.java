package baseball.domain;

import baseball.domain.ball.Balls;
import baseball.model.User;
import baseball.ui.Input;
import baseball.ui.Message;
import baseball.ui.Output;
import baseball.utils.Utility;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private final int NUMBER_BALLS;
    private final Input input;
    private final Output output;
    private List<Command> commands = new ArrayList<>();
    private Computer computer;
    private User user;

    public Game(final int NUMBER_BALLS, final Input input, final Output output) {
        this.NUMBER_BALLS = NUMBER_BALLS;
        this.input = input;
        this.output = output;

        initGameCommand();
    }

    private void initGameCommand() {
        commands.add(Command.RESTART);
        commands.add(Command.END);
    }

    public void run() {
        initPlayer();
        while (true) {
            output.print(Message.START);
            play();
            if (!isRestart()) {
                break;
            }
        }
    }

    private void play() {
        computer.generatePlayerNumber(NUMBER_BALLS);
        while (true) {
            if (isAnswer()) {
                break;
            }
        }
        output.print(Message.END);
    }

    private void initPlayer() {
        user = new User(input);
        computer = new Computer(output);
    }

    private boolean isAnswer() {
        BallCounter ballCounter = countBall();
        return ballCounter.isAllStrike(NUMBER_BALLS);
    }

    private BallCounter countBall() {
        BallCounter ballCounter = new BallCounter(computer.getNumbers(), guessNumber());
        computer.announceResult(ballCounter);
        return ballCounter;
    }

    private Balls guessNumber() {
        output.print(Message.REQUEST_INPUT);
        user.generatePlayerNumber(NUMBER_BALLS);
        return Utility.convertStringToBalls(user.getNumbers(), NUMBER_BALLS);
    }

    private boolean isRestart() {
        Command command = decideRestart();
        return command.isRestart();
    }

    private Command decideRestart() {
        output.print(Message.RESTART);
        return user.selectCommand();
    }
}