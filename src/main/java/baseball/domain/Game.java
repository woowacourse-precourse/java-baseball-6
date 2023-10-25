package baseball.domain;

import baseball.ui.ConsoleInput;
import baseball.ui.ConsoleOutput;
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
            consoleOutput.printMessage("숫자 야구 게임을 시작합니다.\n");
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
        consoleOutput.printMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
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
        consoleOutput.printMessage("숫자를 입력해주세요 : ");
        user.generatePlayerNumber(NUMBER_BALLS);
    }

    private boolean isRestart() {
        Command command = chooseRestartGame();
        return Objects.equals(command.getCommand(), "1");
    }

    private Command chooseRestartGame() {
        consoleOutput.printMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        return user.selectCommand();
    }
}
