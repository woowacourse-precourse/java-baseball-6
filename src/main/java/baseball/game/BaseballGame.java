package baseball.game;

import baseball.computer.Computer;
import baseball.utils.match.MatchResults;
import baseball.player.Player;
import baseball.utils.view.Input;
import baseball.utils.view.Messages;
import baseball.utils.view.Output;

public class BaseballGame {
    private final Computer computer;
    private final Player player;
    private final Input input = new Input();
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
            selectPlayerNumbers();
        }
    }

    private void generateComputerNumbers() {
        computer.generateNumbers();
    }

    private void selectPlayerNumbers() {
        while (gameStatus.isPlay()) {
            inputNumbers();
            MatchResults results = computer.compare(player.getNumbers());
            output.printMessageLine(results.getResultMessage());
            if (results.isAllStrike()) {
                gameStatus = GameStatus.FINISH;
                output.printMessageLine(Messages.FINISH.getMessage());
            }
        }
    }

    private void inputNumbers() {
        output.printMessage(Messages.INPUT.getMessage());
        player.inputNumbers(input.inputNumbers());
    }
}
