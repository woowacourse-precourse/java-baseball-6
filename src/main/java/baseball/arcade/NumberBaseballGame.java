package baseball.arcade;

import baseball.counter.CountResult;
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
    private final Computer computer;
    private final Player player;
    private boolean isGameEnd;

    public NumberBaseballGame() {
        this.computer = new Computer();
        this.player = new Player();
        this.isGameEnd = false;
    }

    public void run() {
        System.out.println(GAME_START);

        do {
            playGame();
            if (isGameEnd) {
                askForGameRestart();
            }
        } while (!isGameEnd);
    }

    private void playGame() {
        String playerNumbersInput = getAndValidatePlayerNumbersInput();
        player.inputNumbers(playerNumbersInput);

        CountResult gameResult = computer.getGameResult(player);

        if (gameResult.strike() == 3) {
            isGameEnd = true;
        }

        printGameResultMessage(gameResult);
    }

    private void askForGameRestart() {
        int restart = getAndValidateRestartInput();

        if (restart == 1) {
            computer.generateNumbers();
            isGameEnd = false;
            return;
        }

        if (restart != 2) {
            throw new IllegalArgumentException(INVALID_RESTART);
        }
    }

    private String getAndValidatePlayerNumbersInput() {
        System.out.print(INPUT_NUMBERS);
        String input = Console.readLine();

        InputValidator.validatePlayerNumbers(input);

        return input;
    }

    private int getAndValidateRestartInput() {
        System.out.println(CHOOSE_RESTART);
        String input = Console.readLine();

        InputValidator.validateRestartInput(input);

        return Integer.parseInt(input);
    }

    private void printGameResultMessage(CountResult gameResult) {
        System.out.println(MessageGenerator.generateGameResultMessage(gameResult));
    }
}
