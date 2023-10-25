package baseball.arcade;

import baseball.counter.StrikeBallCount;
import baseball.message.MessagePrinter;
import baseball.model.Computer;
import baseball.rules.InputValidator;
import baseball.model.Player;
import camp.nextstep.edu.missionutils.Console;

import static baseball.message.ErrorMessages.INVALID_RESTART;
import static baseball.rules.GameConstants.END;
import static baseball.rules.GameConstants.RESTART;

public class NumberBaseballGame {
    private Computer computer;
    private boolean isGameEnd;

    public NumberBaseballGame() {
        this.computer = Computer.generateComputerAsRandomNumbers();
        this.isGameEnd = false;
    }

    public void run() {
        MessagePrinter.printGameStartMessage();

        do {
            playGame();
            if (isGameEnd) {
                askForGameRestart();
            }
        } while (!isGameEnd);

        Console.close();
    }

    private void playGame() {
        String playerNumbersInput = getPlayerNumbersInput();
        Player player = Player.generatePlayerAsInput(playerNumbersInput);

        StrikeBallCount gameResult = computer.getGameResult(player);

        if (gameResult.strike() == 3) {
            isGameEnd = true;
        }

        MessagePrinter.printGameResultMessage(gameResult);
    }

    private void askForGameRestart() {
        String restart = getAndValidateRestartInput();

        if (restart.equals(RESTART)) {
            computer = Computer.generateComputerAsRandomNumbers();
            isGameEnd = false;
            return;
        }

        if (!restart.equals(END)) {
            throw new IllegalArgumentException(INVALID_RESTART);
        }
    }

    private String getPlayerNumbersInput() {
        MessagePrinter.printInputNumbersMessage();
        return Console.readLine();
    }

    private String getAndValidateRestartInput() {
        MessagePrinter.printChooseRestartMessage();
        String input = Console.readLine();

        InputValidator.validateRestartInput(input);

        return input;
    }
}
