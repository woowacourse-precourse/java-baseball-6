package baseball.domain;

import baseball.ui.ConsoleInput;
import baseball.ui.ConsoleOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {

    private final int NUMBER_BALLS;
    private final ConsoleInput CONSOLE_INPUT;
    private final ConsoleOutput CONSOLE_OUTPUT;
    private List<Command> commands = new ArrayList<>();
    private Computer computer;
    private User user;

    public Game(final int numberBalls, final ConsoleInput CONSOLE_INPUT, final ConsoleOutput CONSOLE_OUTPUT) {
        this.NUMBER_BALLS = numberBalls;
        this.CONSOLE_INPUT = CONSOLE_INPUT;
        this.CONSOLE_OUTPUT = CONSOLE_OUTPUT;

        commands.add(Command.RESTART);
        commands.add(Command.END);
    }

    public void run() {
        do {
            CONSOLE_OUTPUT.printMessage("숫자 야구 게임을 시작합니다.\n");
            play();
        } while (isRestart());
    }

    private void play() {
        user = new User(CONSOLE_INPUT, NUMBER_BALLS);
        computer = new Computer(CONSOLE_OUTPUT, NUMBER_BALLS);
        computer.generatePlayerNumber(NUMBER_BALLS);

        do {
            CONSOLE_OUTPUT.printMessage("숫자를 입력해주세요 : ");
            user.generatePlayerNumber(NUMBER_BALLS);
        } while (computer.respondsTo(user));

        CONSOLE_OUTPUT.printMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
    }

    private boolean isRestart() {
        CONSOLE_OUTPUT.printMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        Command command = user.selectCommand();

        return Objects.equals(command.getCommand(), "1");
    }
}
