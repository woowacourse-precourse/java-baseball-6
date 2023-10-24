package baseball;

import baseball.model.Computer;
import baseball.model.Player;
import camp.nextstep.edu.missionutils.Console;

import static baseball.message.ErrorMessages.INVALID_RESTART;
import static baseball.message.Messages.CHOOSE_RESTART;
import static baseball.message.Messages.GAME_START;
import static baseball.message.Messages.INPUT_NUMBERS;
import static baseball.message.Messages.RESULT_3_STRIKE;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Player player = new Player();

        System.out.println(GAME_START);

        while (true) {
            System.out.print(INPUT_NUMBERS);

            String input = Console.readLine();
            player.inputNumbers(input);

            String gameResultMessage = computer.getGameResultMessage(player);
            System.out.println(gameResultMessage);

            if (gameResultMessage.equals(RESULT_3_STRIKE)) {
                System.out.println(CHOOSE_RESTART);
                int restart = Integer.parseInt(Console.readLine());

                if (restart == 1) {
                    computer.generateNumbers();
                    continue;
                }
                if (restart == 2) {
                    break;
                }

                throw new IllegalArgumentException(INVALID_RESTART);
            }
        }
    }
}
