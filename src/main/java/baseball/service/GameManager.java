package baseball.service;

import static baseball.util.MessageFormatter.GAME_EXIT;
import static baseball.util.MessageFormatter.GAME_RESTART;
import static baseball.util.MessageFormatter.GAME_START;
import static baseball.util.MessageFormatter.INPUT_OPTION;
import static baseball.util.MessageFormatter.INVALID_INPUT;
import static baseball.util.MessageFormatter.OPTION_EXIT;
import static baseball.util.MessageFormatter.OPTION_RETRY;

import baseball.domain.Computer;
import baseball.util.WrappedString;
import camp.nextstep.edu.missionutils.Console;

public class GameManager {
    private final Computer computer = new Computer();
    private final BaseballService bs = new BaseballService();

    public void playBaseballGame() {
        while (true) {
            getStart();
            if (isContinue()) {
                System.out.println(GAME_EXIT);
                break;
            }
            System.out.println(GAME_RESTART);
            computer.resetRandomNumber();
        }
    }

    private void getStart() {
        System.out.println(GAME_START);
        bs.startGame(computer);
    }

    private boolean isContinue() {
        System.out.println(INPUT_OPTION);
        while (true) {
            WrappedString userAnswer = new WrappedString(Console.readLine());
            String validAnswer = userAnswer.getValue();
            if (isValidResponse(validAnswer)) {
                return validAnswer.equals(OPTION_EXIT);
            }
            System.out.println(INVALID_INPUT);
        }
    }

    private boolean isValidResponse(String response) {
        return response.equals(OPTION_EXIT) || response.equals(OPTION_RETRY);
    }
}
