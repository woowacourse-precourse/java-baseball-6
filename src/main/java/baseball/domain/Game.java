package baseball.domain;

import baseball.ui.IInput;
import baseball.ui.IOutput;
import baseball.ui.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {

    private final int NUMBER_BALLS;
    private final IInput input;
    private final IOutput output;
    private List<Command> commands = new ArrayList<>();
    private Computer computer;
    private User user;

    public Game(final int NUMBER_BALLS, final IInput input, final IOutput output) {
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
        while (true) {
            output.print(Message.START);
            play();
            if (!isRestart()) {
                break;
            }
        }
    }

    private void play() {
        initPlayer();
        while (true) {
            if (isUserGuessAnswer()) {
                break;
            }
        }
        output.print(Message.END);
    }

    private void initPlayer() {
        user = new User(input, NUMBER_BALLS);
        computer = new Computer(output, NUMBER_BALLS);
        computer.generatePlayerNumber(NUMBER_BALLS);
    }

    private boolean isUserGuessAnswer() {
        guessNumberComputer();
        return !computer.respondsTo(user);
    }

    private void guessNumberComputer() {
        output.print(Message.REQUEST_INPUT);
        user.generatePlayerNumber(NUMBER_BALLS);
    }

    private boolean isRestart() {
        Command command = chooseRestartGame();
        return Objects.equals(command.getCommand(), "1");
    }

    private Command chooseRestartGame() {
        output.print(Message.RESTART);
        return user.selectCommand();
    }
}
