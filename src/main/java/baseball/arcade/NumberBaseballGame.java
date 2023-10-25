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
        int restart = getAndValidateRestartInput();

        if (restart == 1) {
            computer = Computer.generateComputerAsRandomNumbers();
            isGameEnd = false;
            return;
        }

        if (restart != 2) {
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

    private int getAndValidateRestartInput() {
        System.out.println(CHOOSE_RESTART);
        String input = Console.readLine();

        InputValidator.validateRestartInput(input);

        return Integer.parseInt(input);
    }

    private void printGameResultMessage(StrikeBallCount gameResult) {
        System.out.println(MessageGenerator.generateGameResultMessage(gameResult));
    }
}
