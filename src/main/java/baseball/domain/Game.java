package baseball.domain;

import baseball.ui.ConsoleInput;
import baseball.ui.ConsoleOutput;
import baseball.ui.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {

    private final int NUMBER_BALLS;
    private final ConsoleInput consoleInput;
    private final ConsoleOutput consoleOutput;
    private List<Command> commands = new ArrayList<>();
    private Computer computer;
    private User user;

    public Game(final int NUMBER_BALLS, final ConsoleInput consoleInput, final ConsoleOutput consoleOutput) {
        this.NUMBER_BALLS = NUMBER_BALLS;
        this.consoleInput = consoleInput;
        this.consoleOutput = consoleOutput;

        initGameCommand();
    }

    private void initGameCommand() {
        commands.add(Command.RESTART);
        commands.add(Command.END);
    }

    public void run() {
        while (true) {
            consoleOutput.print(Message.START);
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
        consoleOutput.print(Message.END);
    }

    private void initPlayer() {
        user = new User(consoleInput, NUMBER_BALLS);
        computer = new Computer(consoleOutput, NUMBER_BALLS);
        computer.generatePlayerNumber(NUMBER_BALLS);
    }

    private boolean isUserGuessAnswer() {
        guessNumberComputer();
        return !computer.respondsTo(user);
    }

    private void guessNumberComputer() {
        consoleOutput.print(Message.REQUEST_INPUT);
        user.generatePlayerNumber(NUMBER_BALLS);
    }

    private boolean isRestart() {
        Command command = chooseRestartGame();
        return Objects.equals(command.getCommand(), "1");
    }

    private Command chooseRestartGame() {
        consoleOutput.print(Message.RESTART);
        return user.selectCommand();
    }
}
