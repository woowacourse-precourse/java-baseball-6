package baseball.arcade;

import baseball.counter.StrikeBallCount;
import baseball.message.MessageGenerator;
import baseball.model.Computer;
import baseball.rules.InputValidator;
import baseball.model.Player;
import camp.nextstep.edu.missionutils.Console;

import static baseball.message.ErrorMessages.INVALID_RESTART;
import static baseball.message.Messages.CHOOSE_RESTART;
import static baseball.message.Messages.GAME_START;
import static baseball.message.Messages.INPUT_NUMBERS;
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
        printGameStartMessage();

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

        printGameResultMessage(gameResult);
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

    private void printGameStartMessage() {
        System.out.println(GAME_START);
    }

    private String getPlayerNumbersInput() {
        System.out.print(INPUT_NUMBERS);
        return Console.readLine();
    }

    private String getAndValidateRestartInput() {
        System.out.println(CHOOSE_RESTART);
        String input = Console.readLine();

        InputValidator.validateRestartInput(input);

        return input;
    }

    private void printGameResultMessage(StrikeBallCount gameResult) {
        System.out.println(MessageGenerator.generateGameResultMessage(gameResult));
    }
}
