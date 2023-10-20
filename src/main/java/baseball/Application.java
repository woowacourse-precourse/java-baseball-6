package baseball;

import baseball.application.GameLauncher;
import baseball.domain.Computer;
import baseball.util.channel.Printer;
import baseball.util.channel.Reader;
import baseball.util.enums.Command;
import baseball.util.enums.GameFlag;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do {
            Computer computer = new Computer();
            GameLauncher launcher = new GameLauncher(computer);
            Printer.print(Command.START_GAME.getCommand());
            launcher.execute();
        } while (Reader.read(Command.ASK_RESUME).equals(GameFlag.RETRY));
    }
}
