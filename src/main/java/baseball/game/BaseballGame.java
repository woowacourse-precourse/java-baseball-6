package baseball.game;

import baseball.computer.Computer;
import baseball.player.Player;
import baseball.utils.view.Messages;
import baseball.utils.view.Output;

public class BaseballGame {
    private final Computer computer;
    private final Player player;
    private final Output output = new Output();
    private GameStatus gameStatus = GameStatus.PLAY;

    public BaseballGame(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public void start() {
        output.printMessageLine(Messages.START.getMessage());
        while (gameStatus.isPlay()) {
            generateComputerNumbers();
        }
    }

    private void generateComputerNumbers() {
        computer.generateNumbers();
    }
}
